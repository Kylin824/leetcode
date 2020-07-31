package org.example.learn.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public class VivoClient {

    public static final String API_UUID = "6b3d8b097f7b3f546e94bceabc5e6efc";
    public static final String API_KEY = "5827ad153530f1877ca20d54d1e1256c";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String QUERY_DOWNLOAD_IMEI_URL = "http://ad-market.vivo.com.cn/v1/downloadImei/query";
    public static final String QUERY_DOWNLOAD_IMEI_NEW_URL = "http://ad-market.vivo.com.cn/v1/downloadImei/query/new";

    public static String postRequest(String requestStr, String url) throws IOException, NoSuchAlgorithmException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse(CONTENT_TYPE);
        String sign = signLocal(requestStr);
        RequestBody body = RequestBody.create(mediaType, "apiUuid=" + API_UUID + "&requestStr=" + requestStr + "&sign=" + sign);
        okhttp3.Request request = new Request.Builder().url(url).method("POST", body)
                .addHeader("Content-Type", CONTENT_TYPE).build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static String signLocal(String requestStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = messageDigest.digest((API_KEY + requestStr).getBytes("UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hex.toUpperCase());
        }
        return stringBuffer.toString();
    }

    private static void queryDownloadImeiNew() throws IOException, NoSuchAlgorithmException {

    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        boolean haveData = true;
        int pageSize = 200;
        int page = 1;
        String reportDate = "20200729"; //下载2019年12月6日数据
        Long lastId = 0L;
        String requestStr = "{\"reportDate\":\"%s\",\"page\":%d,\"pageSize\":%d,\"lastId\":%d}";
        while (haveData) {
            String responseBodyStr = postRequest(String.format(requestStr, reportDate, page, pageSize, lastId), QUERY_DOWNLOAD_IMEI_URL);
            Response pageResponse = JSON.parseObject(responseBodyStr, Response.class);

            if (pageResponse != null && pageResponse.getCode() == ResponseCodeEnum.SUCCESS.getCode() && pageResponse.getData() != null) {

                ResponseData data = pageResponse.getData();
                List<JSONObject> dataList = data.getList();

                dataList.forEach(x -> {
                    DownloadImeiInfo info = JSONObject.parseObject(String.valueOf(x), DownloadImeiInfo.class);
                    System.out.println(info.getImei() != null ? info.getImei() : info.getOaid());
                });
                if (dataList != null && dataList.size() != 0) {
                    lastId += dataList.size();
                    page++;
                    System.out.println("\nlastId: " + lastId);
                    System.out.println("page info: " + pageResponse.getData().getPageInfo());
                }
            }
            else {
                haveData = false;
            }
        }
    }

    @Data
    static class DownloadImeiNewInfo extends DownloadImeiInfo implements Serializable {

        private static final long serialVersionUID = -7119703798580338118L;
        /**
         * 下载imei记录标识
         */
        private Long id;
    }


    /**
     * 下载imei信息
     *
     * @author vivo
     * @date 2020/03/06.
     */
    @Data
    static class DownloadImeiInfo implements Serializable {
        private static final long serialVersionUID = 468288638031355425L;
        private String imei;
        private String oaid;
        private Integer av;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date downBegin;
        private Integer platform;
        private Integer channel;
        private Integer adPlace;
        private String adId;
        private String adName;
        private String planId;
        private String planName;
        private String appPackage;
    }

    /**
     * 分页返回信息包装类
     *
     * @author chenkh
     * @date 2018/7/25
     */
    @Data
    static class ResponseData<T> implements Serializable {
        private static final long serialVersionUID = 1986416419380131780L;
        private List list;
        private PageInfo pageInfo;
    }

    /**
     * 分页信息
     *
     * @author chenkh
     * @date 2018/7/24.
     */
    @Data
    static class PageInfo implements Serializable {
        /**
         * 序列化版本号
         */
        private static final long serialVersionUID = -3037253494629655471L;

        /**
         * 搜索页码
         */
        private int pageNum = 1;

        /**
         * 一页的数据条数
         */
        private int pageSize = 100;
        /**
         * 总条数
         */
        private int totalNumber;
        /**
         * 总页数
         */
        private int totalPage;

        public PageInfo() {
        }

        public PageInfo(int pageNum, int pageSize, int totalNumber, int totalPage) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.totalNumber = totalNumber;
            this.totalPage = totalPage;
        }
    }

    @Data
    static class Response<T> implements Serializable {

        private static final long serialVersionUID = -109440419305869041L;

        private int code;

        private String msg;

        private ResponseData data;
    }

    /**
     * 响应体枚举
     */
    static enum ResponseCodeEnum {
        SUCCESS(0, "成功"),
        SYSTEM_ERROR(10000, "系统内部错误"),
        DMP_FILE_FORMAT_ILLEGAL(12508, "文件格式非法"),
        DMP_FILE_FORMAT_ERROR(12511, "文件内容格式不正确"),
        DMP_CREATE_INSELL_CROWD_FAIL(12512, "内销创建人群失败"),
        DMP_SAVE_FILE_FAIL(12513, "文件保存失败"),
        DMP_UPLOAD_HIVE_FAIL(12514, "文件上传HIVE服务器失败"),
        DMP_CROWD_TRY_UPDATE_LIMIT(12515, "该上传人群尝试更新超频"),
        DMP_CROWD_UPDATE_LIMIT(12516, "该上传人群更新超频"),
        DMP_SYNC_CROWD_OUT_UPDATE(12517, "该上传人群是同步人群不能更新"),
        DMP_CROWD_CAN_NOT_UPDATE(12518, "该上传人群为不可更新状态"),
        DMP_CROWD_KIND_CAN_NOT_MATCH(12519, "该上传人群的匹配类型与之前不相同"),
        DMP_CROWD_UPDATE_DAIL(12520, "该上传人群更新失败"),
        DMP_CROWD_OUT_DATE(12521, "该上传人群已过期，不能更新"),
        DMP_CREOWS_NOT_EXISIT(11518, "人群不存在"),
        WRONG_REQUEST(20001, "请求参数错误，"),
        NOT_ALLOW_WHITE_LIST(30001, "请求ip不在白名单内"),
        NOT_PERMISSION(30002, "没有权限访问该接口"),
        FREQUENCY_MIN(30003, "请求次数超过分钟频控"),
        FREQUENCY_DAY(30004, "请求次数超过每日频控"),
        SIGN_NOT_MATCH(30005, "签名信息不匹配"),
        PAGE_SIZE_MORE_THAN_UPPER_LIMIT(30006, "每页条数超过上限"),
        ;

        private final int code;
        private final String msg;

        ResponseCodeEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
