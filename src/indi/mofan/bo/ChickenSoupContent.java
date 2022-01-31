package indi.mofan.bo;

import java.util.List;
import java.util.Map;

/**
 * @author cheny
 * @date 2022/1/31 17:12
 */
public class ChickenSoupContent {
   private Integer status;
   private String msg;
   private List<Map<String, String>> data;
   private Long timestamp;

   public Integer getStatus() {
      return status;
   }

   public void setStatus(Integer status) {
      this.status = status;
   }

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public List<Map<String, String>> getData() {
      return data;
   }

   public void setData(List<Map<String, String>> data) {
      this.data = data;
   }

   public Long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
   }
}
