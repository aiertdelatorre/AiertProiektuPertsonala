package dambi.aiertproiektupertsonala;


import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface DelitoRepository {

    List<Delito> eskuratuDenak();
    Delito billatuId(String id);
    Delito ezabatu(String id);
    Delito eguneratu(String id,String field,String value);
    Delito gorde(int DR_NO,
    String Date_Rptd,
    String DATE_OCC,
    int TIME_OCC,
    int AREA,
    String AREA_NAME,
    int Rpt_Dist_No,
    int Part,
    int Crm_Cd,
    String Crm_Cd_Desc,
    int Vict_Age,
    String Vict_Sex,
    String Vict_Descent,
    int Premis_Cd,
    String Premis_Desc,
    int Weapon_Used_Cd,
    String Weapon_Desc,
    String Status,
    String Status_Desc,
    int Crm_Cd_1,
    int Crm_Cd_2,
    int Crm_Cd_3,
    int Crm_Cd_4,
    String LOCATION,
    String Cross_Street,
    double LAT,
    double LON);

    /*@Query("{'year': ?0, 'category': ?1}")
    Delito findByCategoryYear(String year, String category);

    @Query("{'year': ?0, 'category': ?1}")
    long deleteByYear(String year, String category);
*/}