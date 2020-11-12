package com.contract.oss;


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;



/**
 * @author deng
 * @version 1.0
 * @description 上传文件到七牛云
 * @date 2020/11/7 23:58
 */
@org.springframework.context.annotation.Configuration
public class UploadOss {

    @Value("${accessKey}")
    String accesskey;

    @Value("${secretKey}")
    String secretKey;

    @Value("${bucketName}")
    String bucketName;


    /**
     * 上传文件到云端
     * @param filePath
     * @return Sting 文件在云端下载链接
     */
    public String uploadOss(String filePath)
    {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath.substring(filePath.lastIndexOf("/")+1);

        Auth auth = Auth.create(accesskey, secretKey);
        String upToken = auth.uploadToken(bucketName);

        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            String domainOfBucket = "http://qjfkdtkza.hd-bkt.clouddn.com";
            String ossUrl=String.format("%s/%s", domainOfBucket, putRet.key);
            return ossUrl;
            //System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;

    }

}
