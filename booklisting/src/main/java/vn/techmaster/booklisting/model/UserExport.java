package vn.techmaster.booklisting.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import vn.techmaster.booklisting.converter.BooleanConverter;


public class UserExport {
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 0)
  private String userId;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 1)
  private String fullName;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 2)
  private String password;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 3)
  private String status = "ACTIVE";
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 4)
  private String groupId;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 5)
  private String roleId;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 6)
  private String saleId;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 7)
  private String email;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 8)
  private String losId;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 9)
  private String nationalId;//can cuoc cong dan
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 10)
  private String passport;//ho chieu
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 11)
  private String phone1;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 12)
  private String phone2;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 13)
  private String description;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 14)
  private String regAdds;//dia chi thuong tru
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 15)
  private String currAdds;//dia chi hien tai
  @CsvBindByName(column = "xxx")
  @CsvCustomBindByPosition(position = 16, converter = BooleanConverter.class)
  private Boolean isSuperAdmin = false;
  @CsvBindByName(column = "xxx")
  @CsvCustomBindByPosition(position = 17, converter = BooleanConverter.class)
  private Boolean isDelete = false;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 18)
  private String channelUser;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 19)
  private String teamName;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 20)
  private String userLos;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 21)
  private String importedStatus;
  @CsvBindByName(column = "xxx")
  @CsvBindByPosition(position = 22)
  private String error;

  public String getImportedStatus() {
    return importedStatus;
  }

  public void setImportedStatus(String importedStatus) {
    this.importedStatus = importedStatus;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getSaleId() {
    return saleId;
  }

  public void setSaleId(String saleId) {
    this.saleId = saleId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLosId() {
    return losId;
  }

  public void setLosId(String losId) {
    this.losId = losId;
  }

  public String getNationalId() {
    return nationalId;
  }

  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRegAdds() {
    return regAdds;
  }

  public void setRegAdds(String regAdds) {
    this.regAdds = regAdds;
  }

  public String getCurrAdds() {
    return currAdds;
  }

  public void setCurrAdds(String currAdds) {
    this.currAdds = currAdds;
  }

  public Boolean getSuperAdmin() {
    return isSuperAdmin;
  }

  public void setSuperAdmin(Boolean superAdmin) {
    isSuperAdmin = superAdmin;
  }

  public Boolean getDelete() {
    return isDelete;
  }

  public void setDelete(Boolean delete) {
    isDelete = delete;
  }

  public String getChannelUser() {
    return channelUser;
  }

  public void setChannelUser(String channelUser) {
    this.channelUser = channelUser;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getUserLos() {
    return userLos;
  }

  public void setUserLos(String userLos) {
    this.userLos = userLos;
  }


}
