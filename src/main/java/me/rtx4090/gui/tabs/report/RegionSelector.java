package me.rtx4090.gui.tabs.report;

import java.util.HashMap;

public class RegionSelector {

    public HashMap<String, String> regions = new HashMap<String, String>();

    RegionSelector(){
        initRegions();

    }
    void initRegions() {
        regions.put("LUU", "基隆市");
        regions.put("TPH", "新北市");
        regions.put("TPE", "台北市");
        regions.put("TYC", "桃園市");
        regions.put("HSH", "新竹縣");
        regions.put("HSC", "新竹市");
        regions.put("MAL", "苗栗縣");
        regions.put("TXG", "台中市");
        regions.put("CWH", "彰化縣");
        regions.put("NTO", "南投縣");
        regions.put("YLH", "雲林縣");
        regions.put("CHY", "嘉義縣");
        regions.put("CYI", "嘉義市");
        regions.put("TNN", "台南市");
        regions.put("KHH", "高雄市");
        regions.put("IUH", "屏東縣");
        regions.put("ILN", "宜蘭縣");
        regions.put("HWA", "花蓮縣");
        regions.put("TTT", "台東縣");
        regions.put("PEH", "澎湖縣");
        regions.put("KMN", "金門縣");
        regions.put("LNN", "連江縣");
    }
}
