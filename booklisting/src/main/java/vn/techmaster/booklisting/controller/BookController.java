package vn.techmaster.booklisting.controller;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.booklisting.model.Book;
import vn.techmaster.booklisting.model.UserImport;

@RestController
@RequestMapping("/book")
public class BookController {
  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"));
    books.add(new Book("Sherlock Homes", "Arthur Conan Doyle"));
    books.add(new Book("Lược sử loài người", "Yuval Noah Harari"));
    return ResponseEntity.ok().body(books);    
  }

  @GetMapping("/importUser")
  public String getall() throws IOException, CsvException {
    CSVReader reader = new CSVReader(new FileReader("C:\\Users\\MY PC\\Desktop\\PTF\\test-opencsv.csv"));
    List<UserImport> userImports = new CsvToBeanBuilder(new FileReader("C:\\Users\\MY PC\\Desktop\\PTF\\test-opencsv.csv"))
        .withType(UserImport.class)
        .withSkipLines(1)
        .build()
        .parse();
    return "";
  }
}
