package item.finn.com.zztest;

/**
 * Created by finn on 17/4/19.
 */

public class VersionRequest  {


    /**
     * latitude : 90.0
     * devicetype : 0
     * vehicleid : feb8eac4-4687-4ed1-af3a-97cccf6a4f7c
     * ntspheader : {"apikey":"bda11d91-7ade-4da1-855d-24adfe39d174","corpid":"1001","errcode":0,"mdinfo":"null|Android Google Nexus 5 - 6.0.0 - API 23 - 1080x1920|Android6.0","productid":"1002","sessionid":"57eeef92-9d46-47dc-be2b-c12a097d0bce","version":"5.7.7","zjid":"95001257"}
     * longitude : 39.950139
     */

    private double latitude;
    private int devicetype;
    private String vehicleid;
    private NtspheaderBean ntspheader;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(int devicetype) {
        this.devicetype = devicetype;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    public NtspheaderBean getNtspheader() {
        return ntspheader;
    }

    public void setNtspheader(NtspheaderBean ntspheader) {
        this.ntspheader = ntspheader;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static class NtspheaderBean {
        /**
         * apikey : bda11d91-7ade-4da1-855d-24adfe39d174
         * corpid : 1001
         * errcode : 0
         * mdinfo : null|Android Google Nexus 5 - 6.0.0 - API 23 - 1080x1920|Android6.0
         * productid : 1002
         * sessionid : 57eeef92-9d46-47dc-be2b-c12a097d0bce
         * version : 5.7.7
         * zjid : 95001257
         */

        private String apikey;
        private String corpid;
        private int errcode;
        private String mdinfo;
        private String productid;
        private String sessionid;
        private String version;
        private String zjid;

        public String getApikey() {
            return apikey;
        }

        public void setApikey(String apikey) {
            this.apikey = apikey;
        }

        public String getCorpid() {
            return corpid;
        }

        public void setCorpid(String corpid) {
            this.corpid = corpid;
        }

        public int getErrcode() {
            return errcode;
        }

        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public String getMdinfo() {
            return mdinfo;
        }

        public void setMdinfo(String mdinfo) {
            this.mdinfo = mdinfo;
        }

        public String getProductid() {
            return productid;
        }

        public void setProductid(String productid) {
            this.productid = productid;
        }

        public String getSessionid() {
            return sessionid;
        }

        public void setSessionid(String sessionid) {
            this.sessionid = sessionid;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getZjid() {
            return zjid;
        }

        public void setZjid(String zjid) {
            this.zjid = zjid;
        }
    }
}
