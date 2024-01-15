package dambi.aiertproiektupertsonala;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.annotation.PostConstruct;

@Repository
public class MongoDBDelitoRepository implements DelitoRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    private MongoClient klientea;
    private MongoCollection<Delito> delitokolekzioa;

    public MongoDBDelitoRepository(MongoTemplate template) {
        this.mongoTemplate = template;
    }

    @PostConstruct
    public void init() {
        delitokolekzioa = klientea.getDatabase("crimes").getCollection("crime", Delito.class);
    }

    @Override
    public List<Delito> eskuratuDenak() {
        return delitokolekzioa.find().limit(100).into(new ArrayList<>());
    }

    @Override
    public Delito billatuId(String id) {
        return delitokolekzioa.find(eq("DR_NO", Integer.parseInt(id))).first();
    }

    @Override
    public Delito ezabatu(String id) {
        Delito delito = delitokolekzioa.find(eq("DR_NO", Integer.parseInt(id))).first();
        delitokolekzioa.deleteOne(eq("DR_NO", Integer.parseInt(id)));
        return delito;
    }

    @Override
    public Delito gorde(@RequestParam int DR_NO,
            @RequestParam String Date_Rptd,
            @RequestParam String DATE_OCC,
            @RequestParam int TIME_OCC,
            @RequestParam int AREA,
            @RequestParam String AREA_NAME,
            @RequestParam int Rpt_Dist_No,
            @RequestParam int Part,
            @RequestParam int Crm_Cd,
            @RequestParam String Crm_Cd_Desc,
            @RequestParam int Vict_Age,
            @RequestParam String Vict_Sex,
            @RequestParam String Vict_Descent,
            @RequestParam int Premis_Cd,
            @RequestParam String Premis_Desc,
            @RequestParam int Weapon_Used_Cd,
            @RequestParam String Weapon_Desc,
            @RequestParam String Status,
            @RequestParam String Status_Desc,
            @RequestParam int Crm_Cd_1,
            @RequestParam int Crm_Cd_2,
            @RequestParam int Crm_Cd_3,
            @RequestParam int Crm_Cd_4,
            @RequestParam String LOCATION,
            @RequestParam String Cross_Street,
            @RequestParam double LAT,
            @RequestParam double LON) {
        Delito delito = new Delito(DR_NO, Date_Rptd, DATE_OCC, TIME_OCC, AREA, AREA_NAME, Rpt_Dist_No, Part, Crm_Cd,
                Crm_Cd_Desc, null, Vict_Age, Vict_Sex, Vict_Descent,
                Premis_Cd, Premis_Desc, Weapon_Used_Cd, Weapon_Desc, Status, Status_Desc, Crm_Cd_1, Crm_Cd_2, Crm_Cd_3,
                Crm_Cd_4, LOCATION, null, LAT, LON);

        return delito;
    }

    @Override
    public Delito eguneratu(String id, String field, String value) {
        Delito delito = delitokolekzioa.find(eq("DR_NO", Integer.parseInt(id))).first();
        switch (field) {
            case "DR_NO":
                delito.DR_NO = Integer.parseInt(value);
                break;
            case "Date_Rptd":
                delito.Date_Rptd = value;
                break;
            case "DATE_OCC":
                delito.DATE_OCC = value;
                break;
            case "TIME_OCC":
                delito.TIME_OCC = Integer.parseInt(value);
                break;
            case "AREA":
                delito.AREA = Integer.parseInt(value);
                break;
            case "AREA_NAME":
                delito.AREA_NAME = value;
                break;
            case "Rpt_Dist_No":
                delito.Rpt_Dist_No = Integer.parseInt(value);
                break;
            case "Part":
                delito.Part = Integer.parseInt(value);
                break;
            case "Crm_Cd":
                delito.Crm_Cd = Integer.parseInt(value);
                break;
            case "Premis_Cd":
                delito.Premis_Cd = Integer.parseInt(value);
                break;
            case "Premis_Desc":
                delito.Premis_Desc = value;
                break;
            case "Weapon_Used_Cd":
                delito.Weapon_Used_Cd = Integer.parseInt(value);
                break;
            case "Weapon_Desc":
                delito.Weapon_Desc = value;
                break;
            case "Status":
                delito.Status = value;
                break;
            case "Status_Desc":
                delito.Status_Desc = value;
                break;
            case "Crm_Cd_1":
                delito.Crm_Cd_1 = Integer.parseInt(value);
                break;
            case "Crm_Cd_2":
                delito.Crm_Cd_2 = Integer.parseInt(value);
                break;
            case "Crm_Cd_3":
                delito.Crm_Cd_3 = Integer.parseInt(value);
                break;
            case "Crm_Cd_4":
                delito.Crm_Cd_4 = Integer.parseInt(value);
                break;
            case "LOCATION":
                delito.LOCATION = value;
                break;
            case "LAT":
                delito.LAT = Integer.parseInt(value);
                break;
            case "LON":
                delito.LON = Integer.parseInt(value);
                break;
            default:
                break;
        }
        delitokolekzioa.deleteOne((eq("DR_NO",id )));
        delitokolekzioa.insertOne(delito);
        return delito;
    }
}
