package br.andrey.spring.endpoint.error;

public class ValidationErrorDetails extends ErrorDetails {
    private String field;
    private String fieldMessage;

    public static final class Builder {
        private String titile;
        private int status;
        private String detail;
        private long timesstamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;
        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder titile(String titile) {
            this.titile = titile;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timesstamp(long timesstamp) {
            this.timesstamp = timesstamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTitile(titile);
            validationErrorDetails.setDetail(detail);
            validationErrorDetails.setDeveloperMessage(developerMessage);
            validationErrorDetails.setTimesstamp(timesstamp);
            validationErrorDetails.setStatus(status);
            return validationErrorDetails;
        }
    }

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }
}
