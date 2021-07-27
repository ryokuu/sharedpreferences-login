package com.nooryoku.uasmoopkasus1;

public class RodaEmpat {
    private String jenis;
    private String engine;
    private String gear;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getEngine() {
        return "- Buka kompartemen mesin.\n" +
                "- Cek kondisi mesin.\n" +
                "- Ganti oli mesin\n" +
                "- Cek Pendingin";
    }

    public String getGear() {
        if(getJenis().equals("SUV")){
            return "- Cek mekanisme 4WD.\n" +
                    "- Cek kabel kopling.\n" +
                    "- Cek mekanisme gear change";
        }
        else {
            return "- Cek sistem gear change";
        }
    }
}
