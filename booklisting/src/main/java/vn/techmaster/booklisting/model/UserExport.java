package vn.techmaster.booklisting.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import vn.techmaster.booklisting.converter.BooleanConverter;


public class UserExport {
  @CsvBindByPosition(position = 0)
  private String userId;
  @CsvBindByPosition(position = 1)
  private String fullName;
  @CsvBindByPosition(position = 2)
  private String password;
  @CsvBindByPosition(position = 3)
  //    private String partnerId;
  @CsvBindByPosition(position = 4)
  private String status = "ACTIVE";
  @CsvBindByPosition(position = 5)
  private String groupId;
  @CsvBindByPosition(position = 6)
  private String roleId;
  @CsvBindByPosition(position = 7)
  private String saleId;
  @CsvBindByPosition(position = 8)
  private String email;
  @CsvBindByPosition(position = 9)
  private String losId;
  @CsvBindByPosition(position = 10)
  //bổ sung thêm trường
  @CsvBindByPosition(position = 11)
  private String nationalId;//can cuoc cong dan
  @CsvBindByPosition(position = 12)
  private String passport;//ho chieu
  @CsvBindByPosition(position = 13)
  private String phone1;
  @CsvBindByPosition(position = 14)
  private String phone2;
  @CsvBindByPosition(position = 15)
  private String description;
  @CsvBindByPosition(position = 16)
  private String regAdds;//dia chi thuong tru
  @CsvBindByPosition(position = 17)
  private String currAdds;//dia chi hien tai
  @CsvCustomBindByPosition(position = 18, converter = BooleanConverter.class)
  private Boolean isSuperAdmin = false;
  @CsvCustomBindByPosition(position = 19, converter = BooleanConverter.class)
  private Boolean isDelete = false;
  @CsvBindByPosition(position = 20)
  private String channelUser;
  @CsvBindByPosition(position = 22)
  private String teamName;
  @CsvBindByPosition(position = 23)
  private String userLos;
  @CsvBindByPosition(position = 24)
  private String importedStatus;
  @CsvBindByPosition(position = 25)
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
