package dambi.aiertproiektupertsonala;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about Delito")
@Document(collection = "crimes")
public class Delito {

    @Schema(description = "The ID of the Delito")
    public int DR_NO;
    @Schema(description = "The name of the Delito")
    public String Date_Rptd;
    public String DATE_OCC;
    public int TIME_OCC;
    public int AREA;
    public String AREA_NAME;
    public int Rpt_Dist_No;
    public int Part;
    public int Crm_Cd;
    public String Crm_Cd_Desc;
    //@Field("Mocodes")
    //public String Mocodes;
    public int Vict_Age;
    public String Vict_Sex;
    public String Vict_Descent;
    public int Premis_Cd;
    public String Premis_Desc;
    public int Weapon_Used_Cd;
    public String Weapon_Desc;
    public String Status;
    public String Status_Desc;
    public int Crm_Cd_1;
    public int Crm_Cd_2;
    public int Crm_Cd_3;
    public int Crm_Cd_4;
    public String LOCATION;
    public String Cross_Street;
    public double LAT;
    public double LON;
    public int[] codigos_delitos = new int[4];
    public double[] coordenadas = new double[2];

    public Delito() {
    }

    public Delito(int dR_NO, String date_Rptd, String dATE_OCC, int tIME_OCC, int aREA, String aREA_NAME,
            int rpt_Dist_No, int part, int crm_Cd, String crm_Cd_Desc, String mocodes, int vict_Age, String vict_Sex,
            String vict_Descent, int premis_Cd, String premis_Desc, int weapon_Used_Cd, String weapon_Desc,
            String status, String status_Desc, int crm_Cd_1, int crm_Cd_2, int crm_Cd_3, int crm_Cd_4, String lOCATION,
            String cross_Street, double lAT, double lON) {
        DR_NO = dR_NO;
        Date_Rptd = date_Rptd;
        DATE_OCC = dATE_OCC;
        TIME_OCC = tIME_OCC;
        AREA = aREA;
        AREA_NAME = aREA_NAME;
        Rpt_Dist_No = rpt_Dist_No;
        Part = part;
        Crm_Cd = crm_Cd;
        Crm_Cd_Desc = crm_Cd_Desc;
        //Mocodes = mocodes;
        Vict_Age = vict_Age;
        Vict_Sex = vict_Sex;
        Vict_Descent = vict_Descent;
        Premis_Cd = premis_Cd;
        Premis_Desc = premis_Desc;
        Weapon_Used_Cd = weapon_Used_Cd;
        Weapon_Desc = weapon_Desc;
        Status = status;
        Status_Desc = status_Desc;
        Crm_Cd_1 = crm_Cd_1;
        Crm_Cd_2 = crm_Cd_2;
        Crm_Cd_3 = crm_Cd_3;
        Crm_Cd_4 = crm_Cd_4;
        LOCATION = lOCATION;
        Cross_Street = cross_Street;
        LAT = lAT;
        LON = lON;
    }

    public int getDR_NO() {
        return DR_NO;
    }

    public void setDR_NO(int dR_NO) {
        DR_NO = dR_NO;
    }

    public String getDate_Rptd() {
        return Date_Rptd;
    }

    public void setDate_Rptd(String date_Rptd) {
        Date_Rptd = date_Rptd;
    }

    public String getDATE_OCC() {
        return DATE_OCC;
    }

    public void setDATE_OCC(String dATE_OCC) {
        DATE_OCC = dATE_OCC;
    }

    public int getTIME_OCC() {
        return TIME_OCC;
    }

    public void setTIME_OCC(int tIME_OCC) {
        TIME_OCC = tIME_OCC;
    }

    public int getAREA() {
        return AREA;
    }

    public void setAREA(int aREA) {
        AREA = aREA;
    }

    public String getAREA_NAME() {
        return AREA_NAME;
    }

    public void setAREA_NAME(String aREA_NAME) {
        AREA_NAME = aREA_NAME;
    }

    public int getRpt_Dist_No() {
        return Rpt_Dist_No;
    }

    public void setRpt_Dist_No(int rpt_Dist_No) {
        Rpt_Dist_No = rpt_Dist_No;
    }

    public int getPart() {
        return Part;
    }

    public void setPart(int part) {
        Part = part;
    }

    public int getCrm_Cd() {
        return Crm_Cd;
    }

    public void setCrm_Cd(int crm_Cd) {
        Crm_Cd = crm_Cd;
    }

    public String getCrm_Cd_Desc() {
        return Crm_Cd_Desc;
    }

    public void setCrm_Cd_Desc(String crm_Cd_Desc) {
        Crm_Cd_Desc = crm_Cd_Desc;
    }

    /*public String getMocodes() {
        return Mocodes;
    }

    public void setMocodes(String mocodes) {
        Mocodes = mocodes;
    }*/

    public int getVict_Age() {
        return Vict_Age;
    }

    public void setVict_Age(int vict_Age) {
        Vict_Age = vict_Age;
    }

    public String getVict_Sex() {
        return Vict_Sex;
    }

    public void setVict_Sex(String vict_Sex) {
        Vict_Sex = vict_Sex;
    }

    public String getVict_Descent() {
        return Vict_Descent;
    }

    public void setVict_Descent(String vict_Descent) {
        Vict_Descent = vict_Descent;
    }

    public int getPremis_Cd() {
        return Premis_Cd;
    }

    public void setPremis_Cd(int premis_Cd) {
        Premis_Cd = premis_Cd;
    }

    public String getPremis_Desc() {
        return Premis_Desc;
    }

    public void setPremis_Desc(String premis_Desc) {
        Premis_Desc = premis_Desc;
    }

    public int getWeapon_Used_Cd() {
        return Weapon_Used_Cd;
    }

    public void setWeapon_Used_Cd(int weapon_Used_Cd) {
        Weapon_Used_Cd = weapon_Used_Cd;
    }

    public String getWeapon_Desc() {
        return Weapon_Desc;
    }

    public void setWeapon_Desc(String weapon_Desc) {
        Weapon_Desc = weapon_Desc;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus_Desc() {
        return Status_Desc;
    }

    public void setStatus_Desc(String status_Desc) {
        Status_Desc = status_Desc;
    }

    public int getCrm_Cd_1() {
        return Crm_Cd_1;
    }

    public void setCrm_Cd_1(int crm_Cd_1) {
        Crm_Cd_1 = crm_Cd_1;
    }

    public int getCrm_Cd_2() {
        return Crm_Cd_2;
    }

    public void setCrm_Cd_2(int crm_Cd_2) {
        Crm_Cd_2 = crm_Cd_2;
    }

    public int getCrm_Cd_3() {
        return Crm_Cd_3;
    }

    public void setCrm_Cd_3(int crm_Cd_3) {
        Crm_Cd_3 = crm_Cd_3;
    }

    public int getCrm_Cd_4() {
        return Crm_Cd_4;
    }

    public void setCrm_Cd_4(int crm_Cd_4) {
        Crm_Cd_4 = crm_Cd_4;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String lOCATION) {
        LOCATION = lOCATION;
    }

        public String getCross_Street() {
        return Cross_Street;
    }

    public void setCross_Street(String cross_Street) {
        Cross_Street = cross_Street;
    }

    public double getLAT() {
        return LAT;
    }

    public void setLAT(double lAT) {
        LAT = lAT;
    }

    public double getLON() {
        return LON;
    }

    public void setLON(double lON) {
        LON = lON;
    }

    public int[] getCodigos_delitos() {
        return codigos_delitos;
    }

    public void setCodigos_delitos(int[] codigos_delitos) {
        this.codigos_delitos = codigos_delitos;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    


}
