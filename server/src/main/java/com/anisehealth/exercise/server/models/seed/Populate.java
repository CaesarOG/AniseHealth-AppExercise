package com.anisehealth.exercise.server.models.seed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set; //set.of, hashset for new

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anisehealth.exercise.server.models.EmploymentStatus;
import com.anisehealth.exercise.server.models.Ethnicity;
import com.anisehealth.exercise.server.models.Gender;
import com.anisehealth.exercise.server.models.Generation;
import com.anisehealth.exercise.server.models.Language;
import com.anisehealth.exercise.server.models.Provider;
import com.anisehealth.exercise.server.models.RelationshipStatus;
import com.anisehealth.exercise.server.models.ReligiousBackground;
import com.anisehealth.exercise.server.models.SexualOrientation;
import com.anisehealth.exercise.server.models.Specialization;
import com.anisehealth.exercise.server.models.StateLocation;
import com.anisehealth.exercise.server.models.TreatmentModality;
import com.anisehealth.exercise.server.repositories.EmploymentStatusRepository;
import com.anisehealth.exercise.server.repositories.EthnicityRepository;
import com.anisehealth.exercise.server.repositories.GenderRepository;
import com.anisehealth.exercise.server.repositories.GenerationRepository;
import com.anisehealth.exercise.server.repositories.LanguageRepository;
import com.anisehealth.exercise.server.repositories.ProviderRepository;
import com.anisehealth.exercise.server.repositories.RelationshipStatusRepository;
import com.anisehealth.exercise.server.repositories.ReligiousBackgroundRepository;
import com.anisehealth.exercise.server.repositories.SexualOrientationRepository;
import com.anisehealth.exercise.server.repositories.SpecializationRepository;
import com.anisehealth.exercise.server.repositories.StateLocationRepository;
import com.anisehealth.exercise.server.repositories.TreatmentModalityRepository;

@Service
public class Populate {

    @Autowired
    private EmploymentStatusRepository employmentStatusRepository;

    @Autowired
    private EthnicityRepository ethnicityRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GenerationRepository generationRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private RelationshipStatusRepository relationshipStatusRepository;

    @Autowired
    private ReligiousBackgroundRepository religiousBackgroundRepository;

    @Autowired
    private SexualOrientationRepository sexualOrientationRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private StateLocationRepository stateLocationRepository;

    @Autowired
    private TreatmentModalityRepository treatmentModalityRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public static void main(String[] args) {
        System.out.println("Hello, Populate!");
    }

    public void populate() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        if (employmentStatusRepository.count() > 0) {
            System.out.println("Records already populated");
            return;
        }

        String employmentStatusPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/employment_statuses.csv";

        try (InputStream is = Files.newInputStream(Paths.get(employmentStatusPath))) {
            List<EmploymentStatus> employmentStatuses = CSVHelper.csvToEmploymentStatuses(is);
            employmentStatuses.forEach(e -> System.out.println(e.getName()));
            employmentStatusRepository.saveAll(employmentStatuses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ethnicitiesPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/ethnicities.csv";
        try (InputStream is = Files.newInputStream(Paths.get(ethnicitiesPath))) {
            List<Ethnicity> ethnicities = CSVHelper.csvToEthnicities(is);
            ethnicities.forEach(e -> System.out.println(e.getName()));
            ethnicityRepository.saveAll(ethnicities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String gendersPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/genders.csv";
        try (InputStream is = Files.newInputStream(Paths.get(gendersPath))) {
            List<Gender> genders = CSVHelper.csvToGenders(is);
            genders.forEach(e -> System.out.println(e.getName()));
            genderRepository.saveAll(genders);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String generationsPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/generations.csv";
        try (InputStream is = Files.newInputStream(Paths.get(generationsPath))) {
            List<Generation> generations = CSVHelper.csvToGenerations(is);
            generations.forEach(e -> System.out.println(e.getName()));
            generationRepository.saveAll(generations);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String languagesPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/languages.csv";
        try (InputStream is = Files.newInputStream(Paths.get(languagesPath))) {
            List<Language> languages = CSVHelper.csvToLanguages(is);
            languages.forEach(e -> System.out.println(e.getName()));
            languageRepository.saveAll(languages);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String relationshipStatusesPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/relationship_statuses.csv";
        try (InputStream is = Files.newInputStream(Paths.get(relationshipStatusesPath))) {
            List<RelationshipStatus> relationshipStatuses = CSVHelper.csvToRelationshipStatuses(is);
            relationshipStatuses.forEach(e -> System.out.println(e.getName()));
            relationshipStatusRepository.saveAll(relationshipStatuses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String religiousBackgroundsPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/religious_backgrounds.csv";
        try (InputStream is = Files.newInputStream(Paths.get(religiousBackgroundsPath))) {
            List<ReligiousBackground> religiousBackgrounds = CSVHelper.csvToReligiousBackgrounds(is);
            religiousBackgrounds.forEach(e -> System.out.println(e.getName()));
            religiousBackgroundRepository.saveAll(religiousBackgrounds);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sexualOrientationsPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/sexual_orientations.csv";
        try (InputStream is = Files.newInputStream(Paths.get(sexualOrientationsPath))) {
            List<SexualOrientation> sexualOrientations = CSVHelper.csvToSexualOrientations(is);
            sexualOrientations.forEach(e -> System.out.println(e.getName()));
            sexualOrientationRepository.saveAll(sexualOrientations);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String specializationsPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/specializations.csv";
        try (InputStream is = Files.newInputStream(Paths.get(specializationsPath))) {
            List<Specialization> specializations = CSVHelper.csvToSpecializations(is);
            specializations.forEach(e -> System.out.println(e.getName()));
            specializationRepository.saveAll(specializations);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String stateLocationsPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/state_locations.csv";
        try (InputStream is = Files.newInputStream(Paths.get(stateLocationsPath))) {
            List<StateLocation> stateLocations = CSVHelper.csvToStateLocations(is);
            stateLocations.forEach(e -> System.out.println(e.getName()));
            stateLocationRepository.saveAll(stateLocations);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String treatmentModalitiesPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/treatment_modalities.csv";
        try (InputStream is = Files.newInputStream(Paths.get(treatmentModalitiesPath))) {
            List<TreatmentModality> treatmentModalities = CSVHelper.csvToTreatmentModalities(is);
            treatmentModalities.forEach(e -> System.out.println(e.getName()));
            treatmentModalityRepository.saveAll(treatmentModalities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String providersPath = "./src/main/java/com/anisehealth/exercise/server/models/seed/providers1.csv";
        try (InputStream is = Files.newInputStream(Paths.get(providersPath))) {
            List<Provider> providers = CSVHelper.csvToProviders(is);
            providers.forEach(e -> System.out.println(e.getFirstName()));
            providerRepository.saveAll(providers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class CSVHelper {
  public static String TYPE = "text/csv";

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<EmploymentStatus> csvToEmploymentStatuses(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<EmploymentStatus> employmentStatuses = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        EmploymentStatus eStatus = new EmploymentStatus(Long.getLong(TYPE), csvRecord.get("Name"));
        employmentStatuses.add(eStatus);
      }

      return employmentStatuses;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Ethnicity> csvToEthnicities(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Ethnicity> ethnicities = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Ethnicity eStatus = new Ethnicity(Long.getLong(TYPE), csvRecord.get("Name"));
        ethnicities.add(eStatus);
      }

      return ethnicities;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Gender> csvToGenders(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Gender> genders = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Gender gdr = new Gender(Long.getLong(TYPE), csvRecord.get("Name"));
        genders.add(gdr);
      }

      return genders;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Generation> csvToGenerations(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Generation> generations = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Generation gen = new Generation(Long.getLong(TYPE), csvRecord.get("Name"), csvRecord.get("Description"));
        generations.add(gen);
      }

      return generations;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Language> csvToLanguages(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Language> languages = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Language lang = new Language(Long.getLong(TYPE), csvRecord.get("Name"));
        languages.add(lang);
      }

      return languages;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<RelationshipStatus> csvToRelationshipStatuses(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<RelationshipStatus> relationshipStatuses = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        RelationshipStatus rStatus = new RelationshipStatus(Long.getLong(TYPE), csvRecord.get("Name"));
        relationshipStatuses.add(rStatus);
      }

      return relationshipStatuses;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<ReligiousBackground> csvToReligiousBackgrounds(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<ReligiousBackground> religiousBackgrounds = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        ReligiousBackground rBackground = new ReligiousBackground(Long.getLong(TYPE), csvRecord.get("Name"));
        religiousBackgrounds.add(rBackground);
      }

      return religiousBackgrounds;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<SexualOrientation> csvToSexualOrientations(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<SexualOrientation> sexualOrientations = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        SexualOrientation sOrientation = new SexualOrientation(Long.getLong(TYPE), csvRecord.get("Name"));
        sexualOrientations.add(sOrientation);
      }

      return sexualOrientations;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Specialization> csvToSpecializations(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Specialization> specializations = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Specialization spec = new Specialization(Long.getLong(TYPE), csvRecord.get("Name"));
        specializations.add(spec);
      }

      return specializations;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<StateLocation> csvToStateLocations(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<StateLocation> stateLocations = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        StateLocation sLocation = new StateLocation(
            Long.getLong(TYPE),
            csvRecord.get("Name"),
            csvRecord.get("Abbreviation")
            );

        stateLocations.add(sLocation);
      }

      return stateLocations;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<TreatmentModality> csvToTreatmentModalities(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<TreatmentModality> treatmentModalities = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        TreatmentModality tModality = new TreatmentModality(Long.getLong(TYPE),csvRecord.get("Name"));
        treatmentModalities.add(tModality);
      }

      return treatmentModalities;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<Provider> csvToProviders(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Provider> providers = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      int i = 1;
      for (CSVRecord csvRecord : csvRecords) {

        List<Ethnicity> ethnicitiesProvider = ethnicitiesOfProvider(csvRecord.get("EthnicityID"));
        List<Language> languagesProvider = languagesOfProvider(csvRecord.get("LanguageID"));
        List<StateLocation> stateLocationsProvider = stateLocationsOfProvider(csvRecord.get("StateID"));
        List<TreatmentModality> treatmentModalitiesProvider = treatmentModalitiesOfProvider(csvRecord.get("TreatmentModalityID"));
        List<Specialization> specializationsProvider = specializationsOfProvider(csvRecord.get("SpecializationID"));

        Provider provider = new Provider(
            Long.getLong(TYPE),
            "username"+String.valueOf(i),
            csvRecord.get("First Name"),
            csvRecord.get("Last Name"),
            Set.copyOf(ethnicitiesProvider),
            new Gender(Long.valueOf(csvRecord.get("GenderID")), "blah"),
            Integer.parseInt(csvRecord.get("No Of Clients Able To Take On")),
            Set.copyOf(languagesProvider),
            Set.copyOf(stateLocationsProvider),
            csvRecord.get("Bio"),
            new SexualOrientation(Long.valueOf(csvRecord.get("SexualOrientationID")), "blah"),
            new ReligiousBackground(Long.valueOf(csvRecord.get("ReligiousBackgroundID")), "blah"),
            Set.copyOf(treatmentModalitiesProvider),
            Set.copyOf(specializationsProvider)
            );
        i++;
        provider.setPassword("password");
        providers.add(provider);
      }

      System.out.println("value when incorrect: "+String.valueOf(providers.get(0).verifyPassword("password1")));
      System.out.println("value when correct: "+String.valueOf(providers.get(0).verifyPassword("password")));

      return providers;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  private static List<Ethnicity> ethnicitiesOfProvider(String ethnicityIDString) {
    String[] ethIDs = ethnicityIDString.split(", ");
    List<Ethnicity> ethnicitiesProvider = new ArrayList<>();

    for (String id : ethIDs) {
      ethnicitiesProvider.add(new Ethnicity(Long.valueOf(id), "blah"));
    }

    return ethnicitiesProvider;
  }

  private static List<Language> languagesOfProvider(String languageIDString) {
    String[] langIDs = languageIDString.split(", ");
    List<Language> languagesProvider = new ArrayList<>();

    for (String id : langIDs) {
      languagesProvider.add(new Language(Long.valueOf(id), "blah"));
    }

    return languagesProvider;
  }

  private static List<StateLocation> stateLocationsOfProvider(String stateLocationIDString) {
    String[] stateLocIDs = stateLocationIDString.split(", ");
    List<StateLocation> stateLocationsProvider = new ArrayList<>();

    for (String id : stateLocIDs) {
      stateLocationsProvider.add(new StateLocation(Long.valueOf(id), "blah", "blah"));
    }

    return stateLocationsProvider;
  }

  private static List<TreatmentModality> treatmentModalitiesOfProvider(String treatmentModalityIDString) {
    String[] tModalityIDs = treatmentModalityIDString.split(", ");
    List<TreatmentModality> treatmentModalitiesProvider = new ArrayList<>();

    for (String id : tModalityIDs) {
      treatmentModalitiesProvider.add(new TreatmentModality(Long.valueOf(id), "blah"));
    }

    return treatmentModalitiesProvider;
  }

  private static List<Specialization> specializationsOfProvider(String specializationIDString) {
    String[] specIDs = specializationIDString.split(", ");
    List<Specialization> specializationsProvider = new ArrayList<>();

    for (String id : specIDs) {
      specializationsProvider.add(new Specialization(Long.valueOf(id), "blah"));
    }

    return specializationsProvider;
  }

}