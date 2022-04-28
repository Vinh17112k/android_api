package com.shoppingservice.shopping_service.utils;

import lombok.Getter;

public class Constants {
  public enum EXPORT_TEMPLATE_TYPE {
    EXCEL(1), PDF(2);
    private int value;

    EXPORT_TEMPLATE_TYPE(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public enum ContactStatus {
    NEW(0L), PROCESSED(1L), REJECTTED(2L);
    @Getter
    private Long value;
    ContactStatus(Long value) {
      this.value = value;
    }
  }

  public enum STATUS {
    ACTIVE(1L, "Hoạt động"),
    INACTIVE(-1L, "Không hoạt động");
    @Getter
    private Long code;
    @Getter
    private String messCode;

    STATUS(Long code, String messCode) {
      this.code = code;
      this.messCode = messCode;
    }

    public static boolean isExistCode(Long code) {
      for (STATUS status : STATUS.values()) {
        if (status.getCode().equals(code)) {
          return true;
        }
      }
      return false;
    }
  }

  public static final String EMAIL_SENDER_PASSWORD = "VanquangATTT98";
  public static final String EMAIL_SENDER = "testsendmailspr@gmail.com";
  public static final String EMAIL_SUBJECT = "Change Password";
  public static final String EMAIL_TEXT = "Đây là mã xác thực để thay đổi mật khẩu của bạn, vui lòng không tiết lộ ra ngoài để đảm bảo về vấn đề bảo mật tài khoản";
  public static final String MAIL_SENDER_HOST = "smtp.gmail.com";
  public static final int MAIL_SENDER_POST = 587;
  public static final int CODE_LIFE_TIME = 5;
  public static final Long VERIFY_CODE_FROM = 100000L;
  public static final Long VERIFY_CODE_TO = 999999L;

  public enum STATUS_CT {
    NEW(0L,"New"),
    PROCESSED(1L,"Processed"),
    REJECTED(2L,"Rejected");
    @Getter
    private Long code;
    @Getter
    private String messCode;
    STATUS_CT(Long code, String messCode) {
      this.code = code;
      this.messCode = messCode;
    }
    public static boolean isExistCode(Long code) {
      for (STATUS status : STATUS.values()) {
        if (status.getCode().equals(code)) {
          return true;
        }
      }
      return false;
    }
  }

  public static final class MEDIA_TYPE {
    private MEDIA_TYPE() {
    }

    public static final String MS_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  }
}
