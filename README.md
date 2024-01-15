# AiertProiektuPertsonala

# Testuingurua
Proiektu hontarako spring-ekin api bat sortzea eskatu digute,mongo-ko cluster batetik datuak jasotzen dituena, horretarako, classeak, repositorioak, controladoreak eta abar.

#Endpointak

	@GetMapping("/select/Dena") //Errepositoriotik datuak eskuratzen ditu
	@GetMapping("/select/AukeratuBatID") // Erregistro bakarra eskuratzen du id aren araberan
	@PutMapping("/update/EguneratuBatID") // Erregistro bat eguneratzen du
	@DeleteMapping("/delete/EzabatuBatID") //Erregistro bakarra ezabatzen du id aren araberan
	@PostMapping("/insert/SartuBat") //Delito bat gordetzen du datu basean

 # Delito Klasea

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

zati honetan ikuesten denez gain, atributu bakoitzeko setter eta getter bat dago, "codigos_delitos" eta "coordenadas" aldagaientzat izan ezik gahinera eremu bakoitza datu baseko izen berdinak ditu, erroreak ekiditeko

DelitoRepository eta MongoDBDelitoRepository


DelitoRepository Klasea

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
    }

MongoDBDelitoRepository Klasea

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

DelitoRepository interface bat da, funtzioak eta honek jasotzen dituzten atributuak definitzen dituztenak, eta bestalde MongoDBDelitoRepository honen implementazioa da.

Dokumentu Bi honez gain application.properties dokumentua aldatu behhar izan dugu, connection String-a pasatuz

# Datuen Iturria

datuak hurengo linketik atera ditut [ https://catalog.data.gov/dataset/crime-data-from-2020-to-present/resource/5eb6507e-fa82-4595-a604-023f8a326099?inner_span=True](url) estatu batuetako gobernuko orrialde bat, izatez, datasetak 750.000 erregistro zituen baina batzuk kendu behar izan ditut, apiak ondo funtzionatzeko

# Dependentziak

Sartu ditudan dependentziak hurrengoak dira:

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.3.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api -->
		<dependency>
			<groupId>jakarta.persistence</groupId>
			<artifactId>jakarta.persistence-api</artifactId>
			<version>3.1.0</version>
		</dependency>

		<dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongodb-driver-sync</artifactId>
            <version>${mongodb.version}</version>
        </dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>

		

	</dependencies>

 aipatzeko garrantzitzuenak mongodb driverr eta springdoc-a dira lehenengoa mongo-ko datubasera konexioa ahalbidetzen du, eta bigarrenak swagger erabiltzeko balio du
