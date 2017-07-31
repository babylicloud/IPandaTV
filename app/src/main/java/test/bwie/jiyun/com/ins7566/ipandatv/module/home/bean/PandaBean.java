package test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lx on 2017/7/11.
 * 总标签页实体Bean
 */

public class PandaBean implements Serializable {
    private List<TabBean> tab;

    public List<TabBean> getTab() {
        return tab;
    }

    public void setTab(List<TabBean> tab) {
        this.tab = tab;
    }

    public static class TabBean  implements Serializable{
        /**
         * title : 首页
         * noimage :
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/15/1450172469187_603.jpg
         * url : http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json
         */

        private String title;
        private String noimage;
        private String image;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNoimage() {
            return noimage;
        }

        public void setNoimage(String noimage) {
            this.noimage = noimage;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
