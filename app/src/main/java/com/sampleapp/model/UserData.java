package com.sampleapp.model;

/**
 * Pojo class for user data
 */
public class UserData {

    /**
     * code : 200
     * message : Success
     */

    private StatusBean status;

    private ResponseBean response;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class StatusBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ResponseBean {

        private AuthBean auth;

        public AuthBean getAuth() {
            return auth;
        }

        public void setAuth(AuthBean auth) {
            this.auth = auth;
        }

        public static class AuthBean {
            private String id;
            private String session_id;

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
