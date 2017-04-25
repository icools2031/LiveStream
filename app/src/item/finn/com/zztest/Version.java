package item.finn.com.zztest;

import java.util.List;

/**
 * Created by finn on 17/4/19.
 */
public class Version  {


    /**
     * ntspheader : {"errcode":0,"errmsg":""}
     * data : {"dtcheck":"2017-04-14 16:56:50","faultcount":4,"indexset":[{"havehistory":1,"key":-2,"maxvalue":11.18,"minvalue":6.02,"name":"启动电压（伏）","reference":"6.02-11.18","status":true,"statuscode":0,"unit":"伏","value":8.6},{"havehistory":1,"key":163,"maxvalue":14.8,"minvalue":13.2,"name":"电瓶充电电压（伏）","reference":"13.2-14.8","status":true,"statuscode":0,"unit":"伏","value":13.57},{"havehistory":1,"key":7,"maxvalue":115,"minvalue":80,"name":"冷却液温度（℃）","reference":"80-115","status":true,"statuscode":0,"unit":"℃","value":97},{"havehistory":1,"key":8,"maxvalue":10,"minvalue":-10,"name":"短期燃油修正值（%）","reference":"-10-10","status":true,"statuscode":0,"unit":"%","value":-7.8},{"havehistory":1,"key":10,"maxvalue":20,"minvalue":-20,"name":"长期燃油修正值（%）","reference":"-20-20","status":true,"statuscode":0,"unit":"%","value":-17.2},{"havehistory":1,"key":6,"maxvalue":50,"minvalue":15,"name":"发动机计算负载（%）","reference":"15-50","status":false,"statuscode":2,"unit":"%","value":64.7},{"havehistory":1,"key":22,"maxvalue":5,"minvalue":2,"name":"空气流量值（克/秒）","reference":"2.0-5.0","status":false,"statuscode":2,"unit":"克/秒","value":9.33},{"havehistory":1,"key":17,"maxvalue":50,"minvalue":25,"name":"进气歧管绝对压力（千帕）","reference":"25-50","status":false,"statuscode":2,"unit":"千帕","value":53},{"havehistory":1,"key":18,"maxvalue":850,"minvalue":550,"name":"怠速时发动机转速（转/分钟）","reference":"550-850","status":true,"statuscode":0,"unit":"转/分钟","value":704},{"havehistory":1,"key":20,"maxvalue":15,"minvalue":6,"name":"点火正时提前角（度）","reference":"6-15","status":true,"statuscode":1,"unit":"度","value":5},{"havehistory":1,"key":21,"maxvalue":70,"minvalue":30,"name":"进气温度（℃）","reference":"30-70","status":true,"statuscode":0,"unit":"℃","value":59},{"havehistory":1,"key":23,"maxvalue":20,"minvalue":12,"name":"绝对节气门位置（%）","reference":"12-20","status":true,"statuscode":0,"unit":"%","value":14.1},{"havehistory":1,"key":164,"maxvalue":40,"minvalue":10,"name":"发动机绝对负载（%）","reference":"10-40","status":false,"statuscode":2,"unit":"%","value":45.9},{"havehistory":1,"key":166,"maxvalue":5,"minvalue":0,"name":"相对节气门位置（%）","reference":"0-5","status":true,"statuscode":0,"unit":"%","value":2.7}]}
     * exceptionitems : null
     * resultdes : null
     * score : 26
     */

    private NtspheaderBean ntspheader;
    private DataBean data;
    private Object exceptionitems;
    private Object resultdes;
    private String score;

    public NtspheaderBean getNtspheader() {
        return ntspheader;
    }

    public void setNtspheader(NtspheaderBean ntspheader) {
        this.ntspheader = ntspheader;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getExceptionitems() {
        return exceptionitems;
    }

    public void setExceptionitems(Object exceptionitems) {
        this.exceptionitems = exceptionitems;
    }

    public Object getResultdes() {
        return resultdes;
    }

    public void setResultdes(Object resultdes) {
        this.resultdes = resultdes;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public static class NtspheaderBean {
        /**
         * errcode : 0
         * errmsg :
         */

        private int errcode;
        private String errmsg;

        public int getErrcode() {
            return errcode;
        }

        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        @Override
        public String toString() {
            return "NtspheaderBean{" +
                    "errcode=" + errcode +
                    ", errmsg='" + errmsg + '\'' +
                    '}';
        }
    }

    public static class DataBean {
        /**
         * dtcheck : 2017-04-14 16:56:50
         * faultcount : 4
         * indexset : [{"havehistory":1,"key":-2,"maxvalue":11.18,"minvalue":6.02,"name":"启动电压（伏）","reference":"6.02-11.18","status":true,"statuscode":0,"unit":"伏","value":8.6},{"havehistory":1,"key":163,"maxvalue":14.8,"minvalue":13.2,"name":"电瓶充电电压（伏）","reference":"13.2-14.8","status":true,"statuscode":0,"unit":"伏","value":13.57},{"havehistory":1,"key":7,"maxvalue":115,"minvalue":80,"name":"冷却液温度（℃）","reference":"80-115","status":true,"statuscode":0,"unit":"℃","value":97},{"havehistory":1,"key":8,"maxvalue":10,"minvalue":-10,"name":"短期燃油修正值（%）","reference":"-10-10","status":true,"statuscode":0,"unit":"%","value":-7.8},{"havehistory":1,"key":10,"maxvalue":20,"minvalue":-20,"name":"长期燃油修正值（%）","reference":"-20-20","status":true,"statuscode":0,"unit":"%","value":-17.2},{"havehistory":1,"key":6,"maxvalue":50,"minvalue":15,"name":"发动机计算负载（%）","reference":"15-50","status":false,"statuscode":2,"unit":"%","value":64.7},{"havehistory":1,"key":22,"maxvalue":5,"minvalue":2,"name":"空气流量值（克/秒）","reference":"2.0-5.0","status":false,"statuscode":2,"unit":"克/秒","value":9.33},{"havehistory":1,"key":17,"maxvalue":50,"minvalue":25,"name":"进气歧管绝对压力（千帕）","reference":"25-50","status":false,"statuscode":2,"unit":"千帕","value":53},{"havehistory":1,"key":18,"maxvalue":850,"minvalue":550,"name":"怠速时发动机转速（转/分钟）","reference":"550-850","status":true,"statuscode":0,"unit":"转/分钟","value":704},{"havehistory":1,"key":20,"maxvalue":15,"minvalue":6,"name":"点火正时提前角（度）","reference":"6-15","status":true,"statuscode":1,"unit":"度","value":5},{"havehistory":1,"key":21,"maxvalue":70,"minvalue":30,"name":"进气温度（℃）","reference":"30-70","status":true,"statuscode":0,"unit":"℃","value":59},{"havehistory":1,"key":23,"maxvalue":20,"minvalue":12,"name":"绝对节气门位置（%）","reference":"12-20","status":true,"statuscode":0,"unit":"%","value":14.1},{"havehistory":1,"key":164,"maxvalue":40,"minvalue":10,"name":"发动机绝对负载（%）","reference":"10-40","status":false,"statuscode":2,"unit":"%","value":45.9},{"havehistory":1,"key":166,"maxvalue":5,"minvalue":0,"name":"相对节气门位置（%）","reference":"0-5","status":true,"statuscode":0,"unit":"%","value":2.7}]
         */

        private String dtcheck;
        private int faultcount;
        private List<IndexsetBean> indexset;

        public String getDtcheck() {
            return dtcheck;
        }

        public void setDtcheck(String dtcheck) {
            this.dtcheck = dtcheck;
        }

        public int getFaultcount() {
            return faultcount;
        }

        public void setFaultcount(int faultcount) {
            this.faultcount = faultcount;
        }

        public List<IndexsetBean> getIndexset() {
            return indexset;
        }

        public void setIndexset(List<IndexsetBean> indexset) {
            this.indexset = indexset;
        }

        public static class IndexsetBean {
            /**
             * havehistory : 1
             * key : -2
             * maxvalue : 11.18
             * minvalue : 6.02
             * name : 启动电压（伏）
             * reference : 6.02-11.18
             * status : true
             * statuscode : 0
             * unit : 伏
             * value : 8.6
             */

            private int havehistory;
            private int key;
            private double maxvalue;
            private double minvalue;
            private String name;
            private String reference;
            private boolean status;
            private int statuscode;
            private String unit;
            private double value;

            public int getHavehistory() {
                return havehistory;
            }

            public void setHavehistory(int havehistory) {
                this.havehistory = havehistory;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public double getMaxvalue() {
                return maxvalue;
            }

            public void setMaxvalue(double maxvalue) {
                this.maxvalue = maxvalue;
            }

            public double getMinvalue() {
                return minvalue;
            }

            public void setMinvalue(double minvalue) {
                this.minvalue = minvalue;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getReference() {
                return reference;
            }

            public void setReference(String reference) {
                this.reference = reference;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public int getStatuscode() {
                return statuscode;
            }

            public void setStatuscode(int statuscode) {
                this.statuscode = statuscode;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "dtcheck='" + dtcheck + '\'' +
                    ", faultcount=" + faultcount +
                    ", indexset=" + indexset +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Version{" +
                "ntspheader=" + ntspheader +
                ", data=" + data +
                ", exceptionitems=" + exceptionitems +
                ", resultdes=" + resultdes +
                ", score='" + score + '\'' +
                '}';
    }
}
