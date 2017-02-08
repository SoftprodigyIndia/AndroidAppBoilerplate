package com.sampleapp.model.response;

/**
 * response model for login api
 */
public class LoginResponse {
    /**
     * result : 1
     * resultText : Success
     * errorMSG : Success.
     * user_id : 20
     */

    private ResponseBean Response;

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public static class ResponseBean {
        private int result;
        private String resultText;
        private String errorMSG;
        private int user_id;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getResultText() {
            return resultText;
        }

        public void setResultText(String resultText) {
            this.resultText = resultText;
        }

        public String getErrorMSG() {
            return errorMSG;
        }

        public void setErrorMSG(String errorMSG) {
            this.errorMSG = errorMSG;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}
