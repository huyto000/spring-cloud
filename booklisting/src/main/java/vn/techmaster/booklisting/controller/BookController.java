package vn.techmaster.booklisting.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.booklisting.converter.CustomMappingStrategy;
import vn.techmaster.booklisting.model.Book;
import vn.techmaster.booklisting.model.UserExport;
import vn.techmaster.booklisting.model.UserImport;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  private JavaMailSender mailSender;

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"));
    books.add(new Book("Sherlock Homes", "Arthur Conan Doyle"));
    books.add(new Book("Lược sử loài người", "Yuval Noah Harari"));
    return ResponseEntity.ok().body(books);    
  }

  @GetMapping("/importUser")
  public String getall() throws IOException, CsvException, MessagingException, TemplateException {
    CSVReader reader = new CSVReader(new FileReader("C:\\Users\\MY PC\\Desktop\\PTF\\test-opencsv.csv"));
    List<UserImport> userImports = new CsvToBeanBuilder(new FileReader("C:\\Users\\MY PC\\Desktop\\PTF\\test-opencsv.csv"))
        .withType(UserImport.class)
        .withSkipLines(1)
        .build()
        .parse();

    List<UserExport> exports = userImports.stream()
        .map(x -> {
          UserExport e = new UserExport();
          BeanUtils.copyProperties(x, e);
          return e;
        })
        .collect(Collectors.toList());
    CustomMappingStrategy<UserExport> mappingStrategy = new CustomMappingStrategy<>();
    mappingStrategy.setType(UserExport.class);
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
    CSVWriter writer = new CSVWriter(streamWriter);
    StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
        .withSeparator(',')
        .withMappingStrategy(mappingStrategy)
        .build();
    beanToCsv.write(exports);
    streamWriter.flush();
    writer.close();
    sendOTPEmail(stream.toByteArray());
    return "";
  }

  public void sendOTPEmail(byte[] arrbyte)
      throws IOException, MessagingException, TemplateException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setFrom("test", "Ptf support");
    helper.setTo("huyto97@gmail.com");

    String subject = "Ptf: Mã OTP !";


    helper.setSubject(subject);
    final InputStreamSource fileStreamSource = new ByteArrayResource(arrbyte);
    helper.addAttachment("testfile.csv", fileStreamSource);
    helper.setText("", true);
    mailSender.send(message);
  }
}
