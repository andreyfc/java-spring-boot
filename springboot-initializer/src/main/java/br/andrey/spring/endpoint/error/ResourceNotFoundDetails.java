package br.andrey.spring.endpoint.error;

public class ResourceNotFoundDetails extends ErrorDetails {
    private String titile;
    private int status;
    private String detail;
    private long timesstamp;
    private String developerMessage;

    private ResourceNotFoundDetails() {

    }

    public String getTitile() {
        return titile;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimesstamp() {
        return timesstamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
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

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.setTitile(titile);
            resourceNotFoundDetails.setDetail(detail);
            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
            resourceNotFoundDetails.setTimesstamp(timesstamp);
            resourceNotFoundDetails.setStatus(status);
            return resourceNotFoundDetails;
        }
    }
}
