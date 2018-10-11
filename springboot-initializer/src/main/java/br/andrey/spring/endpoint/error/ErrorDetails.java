package br.andrey.spring.endpoint.error;

public class ErrorDetails {
    private String titile;
    private int status;
    private String detail;
    private long timesstamp;
    private String developerMessage;


    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimesstamp() {
        return timesstamp;
    }

    public void setTimesstamp(long timesstamp) {
        this.timesstamp = timesstamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public static final class Builder {
        private String titile;
        private int status;
        private String detail;
        private long timesstamp;
        private String developerMessage;

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

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitile(titile);
            errorDetails.setStatus(status);
            errorDetails.setDetail(detail);
            errorDetails.setTimesstamp(timesstamp);
            errorDetails.setDeveloperMessage(developerMessage);
            return errorDetails;
        }
    }
}
