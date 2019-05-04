package com.metaopsis.icsapi.v2.dom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class User {
    @JsonProperty("@type")
    private String type;
    private String id;
    private String orgId;
    private String name;
    private String createTime;
    private String updateTime;
    private String createdBy;
    private String updatedBy;
    private String firstName;
    private String lastName;
    private String title;
    private String phone;
    private String emails;
    private String timezone;
    private String serverUrl;
    private String spiUrl;
    private String icSessionId;
    private String securityQuestion;
    private boolean forceChangePassword;
    private String uuid;
    private UserGroup[] usergroups;
    private Role[] roles;

    public User() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSpiUrl() {
        return spiUrl;
    }

    public void setSpiUrl(String spiUrl) {
        this.spiUrl = spiUrl;
    }

    public String getIcSessionId() {
        return icSessionId;
    }

    public void setIcSessionId(String icSessionId) {
        this.icSessionId = icSessionId;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public boolean isForceChangePassword() {
        return forceChangePassword;
    }

    public void setForceChangePassword(boolean forceChangePassword) {
        this.forceChangePassword = forceChangePassword;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserGroup[] getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(UserGroup[] usergroups) {
        this.usergroups = usergroups;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", emails='" + emails + '\'' +
                ", timezone='" + timezone + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", spiUrl='" + spiUrl + '\'' +
                ", icSessionId='" + icSessionId + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", forceChangePassword=" + forceChangePassword +
                ", uuid='" + uuid + '\'' +
                ", usergroups=" + Arrays.toString(usergroups) +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }
}
