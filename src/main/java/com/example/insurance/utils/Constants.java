package com.example.insurance.utils;

public class Constants {

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAILURE_CODE = 500;
    public static final String SUCCESS_MESSAGE = "Success";

    public static final String NO_CLAIMS_FOUND = "No claims found for customer ID: ";
    public static final String INVALID_CLAIM_ID = "Claim ID cannot be null";
    public static final String NO_CUSTOMER_FOUND = "No Customer found for customer ID: ";

    public static final String INVALID_CLAIM_STATUS = "Claim Status cannot be null";

    public enum ClaimStatusEnum {
        OPEN(1, "Open"),
        CLOSED(2, "Closed");

        private final int id;
        private final String description;

        ClaimStatusEnum(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public static String getDescriptionById(int id) {
            for (ClaimStatusEnum status : ClaimStatusEnum.values()) {
                if (status.getId() == id) {
                    return status.getDescription();
                }
            }
            return "";
        }
    }

    public enum InsuranceTypeEnum {
        CAR(1, "Car"),
        Travel(2, "Travel"),
        HEALTH(3, "Health");

        private final int id;
        private final String description;

        InsuranceTypeEnum(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public static String getDescriptionById(int id) {
            for (InsuranceTypeEnum status : InsuranceTypeEnum.values()) {
                if (status.getId() == id) {
                    return status.getDescription();
                }
            }
            return "";
        }
    }
}
