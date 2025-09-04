package com.trucdulieu.commoncategory.config;

public final class QueryValue {
    public static final String CHECKUP_BANK = """
                SELECT * FROM bank WHERE
                        (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
                        (CASE WHEN :description <> '' THEN description = :description ELSE true END) AND
                        (CASE WHEN :bin <> '' THEN bin = :bin ELSE true END) AND
                        (CASE WHEN :code <> '' THEN code = :code ELSE true END) AND
                        (CASE WHEN :shortName <> '' THEN short_name = :shortName ELSE true END) AND
                        (CASE WHEN :swiftCode <> '' THEN swift_code = :swiftCode ELSE true END)
            """;

    public static final String CHECK_MSG = """
                SELECT * FROM Medical_Supply_Group WHERE
                        (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
                        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name ,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code ,'%'))) ELSE TRUE END)
            """;

    public static final String CHECK_MEDICAL_ROUTE = """
                SELECT * FROM Medical_Route WHERE
                        (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
                        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name ,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%'))) ELSE TRUE END)
            """;

    public static final String CHECK_KCBT = """
                SELECT * FROM Kham_Chua_Benh WHERE
                        (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
                        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name ,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%'))) ELSE TRUE END)
            """;
    public static final String CHECK_HTSS = """
                SELECT * FROM Healthcare_technical_services_status WHERE
                        (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
                        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name ,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code ,'%'))) ELSE TRUE END) AND
                        (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%'))) ELSE TRUE END)
            """;
    public static final String CHECKUP_CAREER = """
                SELECT * FROM career WHERE
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END)
            """;
    public static final String CHECKUP_JOBTITL = """
                SELECT * FROM job_titl WHERE
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END)
            """;
    public static final String CHECKUP_POSITION = """
                SELECT * FROM position WHERE
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END) AND
            """;
    public static final String CHECKUP_DIAGNOSICIMAGING = """
                SELECT * FROM diagnostic_imaging WHERE
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END)
            """;
    public static final String CHECKUP_GENDER = """
            SELECT * FROM genders WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_CLINIC = """
            SELECT * FROM clinic WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
                   """;

    public static final String CHECKUP_SICKBED = """
            SELECT * FROM sick_bed WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
                   """;

    public static final String FILTER_CITY = """
            SELECT * FROM city WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :regions <> '' THEN LOWER(regions) LIKE(LOWER(CONCAT('%', :regions, '%'))) ELSE true END)""";
    public static final String FILTER_ANALYZERMACHINE = """
            SELECT * FROM analyzer_machines WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :machine_code <> '' THEN LOWER(machine_code) LIKE(LOWER(CONCAT('%', :machine_code, '%'))) ELSE true END);   
            """;
    public static final String CHECKUP_TESTINDEX = """
                SELECT * FROM test_index WHERE
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END) AND
                (CASE WHEN :referenceValue is not null THEN reference_value = :referenceValue ELSE true END) AND
                (CASE WHEN :unit is not null THEN unit = :unit ELSE true END)
            """;
    public static final String CHECKUP_IMAGEDIAGNOSTICMACHINE = """
                SELECT * FROM image_diagnstic_machine WHERE 
                (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
                (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name,'%')))  ELSE true END) AND
                (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%')))  ELSE true END) AND
                (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code,'%')))  ELSE true END)
            (CASE WHEN :regions <> '' THEN regions = :regions ELSE true END)           
            """;
    public static final String CHECKUP_MEDICALRECORDTEMPLATE = """
            SELECT * FROM medical_record_template WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_MANUFACTURER = """
            SELECT * FROM manufacturer WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :companyName <> '' THEN LOWER(company_name) LIKE(LOWER(CONCAT('%', :companyName, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_UNIT = """
            SELECT * FROM unit WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_MANUFACTURINGCOUNTRY = """
            SELECT * FROM manufacturing_country WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;

    public static final String CHECKUP_TECHNICALSERVICEGROUP = """
            SELECT * FROM technical_service_group WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_SUBJECTSOFMEDICALEXAMINATIONANDTREATMENT = """
            SELECT * FROM subjects_of_medical_examination_and_treatment WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description, '%'))) ELSE true END)
                """;
    public static final String CHECKUP_ICD10 = """
            SELECT * FROM icd WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code, '%'))) ELSE true END) AND
            (CASE WHEN :chapter <> '' THEN LOWER(chapter) LIKE(LOWER(CONCAT('%', :chapter, '%'))) ELSE true END) AND
            (CASE WHEN :group <> '' THEN LOWER(groups) LIKE(LOWER(CONCAT('%', :group, '%'))) ELSE true END)
                """;

    public static final String CHECKUP_TENDER_DECISION = """
            SELECT * FROM tender_decision WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :unit_name <> '' THEN LOWER(unit_name) LIKE(LOWER(CONCAT('%', :unit_name, '%'))) ELSE true END) AND
            (CASE WHEN :tenderNumber <> '' THEN LOWER(tender_number) LIKE(LOWER(CONCAT('%', :tenderNumber, '%'))) ELSE true END) AND
            (CASE WHEN :decision <> '' THEN LOWER(decision) LIKE(LOWER(CONCAT('%', :decision, '%'))) ELSE true END) AND
            (CASE WHEN :decisionDate <> '' THEN LOWER(decision_date) LIKE(LOWER(CONCAT('%', :decisionDate, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_CHEMICAL_INTERACTION = """
            SELECT * FROM chemical_interaction WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (Case WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code, '%'))) ELSE true END) AND
            (CASE WHEN :interaction <> '' THEN LOWER(interaction) LIKE(LOWER(CONCAT('%', :interaction, '%'))) ELSE true END) AND
            (CASE WHEN :creator <> '' THEN LOWER(creator) LIKE(LOWER(CONCAT('%', :creator, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_PACKAGE_TYPE = """
            SELECT * FROM package_type WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_DEPARTMENT = """
            SELECT * FROM department WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_WARD = """
            SELECT * FROM wardd WHERE
            (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name ,'%'))) ELSE TRUE END) AND
            (CASE WHEN :description <> '' THEN LOWER(description) LIKE(LOWER(CONCAT('%', :description,'%'))) ELSE TRUE END)
            """;
    public static final String CHECKUP_HIS = """
            SELECT * FROM Heal_Insurance_Status WHERE
            (CASE WHEN :id IS NOT NULL THEN id = :id ELSE TRUE END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE TRUE END)
            """;
    public static final String CHECKUP_DISTRICT = """
        SELECT * FROM districts WHERE
        (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
        (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
        """;

    public static final String CHECKUP_ETHNIC = """
            SELECT * FROM ethnics WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_PAYMENT_METHOD = """
            SELECT * FROM payment_method WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
            """;

    public static final String CHECKUP_TEST_CATALOG = """
            SELECT * FROM test_catalog WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code, '%'))) ELSE true END) AND
            (CASE WHEN :index <> '' THEN LOWER(index) LIKE(LOWER(CONCAT('%', :index, '%'))) ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END)
            """;
    public static final String FILTER_TECHNICALSERVICES = """
            SELECT * FROM classification_technical_services WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :code <> '' THEN LOWER(code) LIKE(LOWER(CONCAT('%', :code, '%'))) ELSE true END)""";
    public static final String FILTER_SUPPLIER = """
            SELECT * FROM supplier WHERE
            (CASE WHEN :id is not null THEN id = :id ELSE true END) AND
            (CASE WHEN :name <> '' THEN LOWER(name) LIKE(LOWER(CONCAT('%', :name, '%'))) ELSE true END) AND
            (CASE WHEN :address <> '' THEN LOWER(address) LIKE(LOWER(CONCAT('%', :address, '%'))) ELSE true END)""";

	
	
}
