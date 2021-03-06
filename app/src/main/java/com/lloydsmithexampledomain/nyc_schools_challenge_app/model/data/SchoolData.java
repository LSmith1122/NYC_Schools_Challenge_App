package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data;

import com.google.gson.annotations.SerializedName;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.utils.ServiceConstants;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

public class SchoolData implements ISchoolData {

    @SerializedName(ServiceConstants.DBN)
    protected String dbn = "";
    @SerializedName(ServiceConstants.SCHOOL_NAME)
    protected String schoolName = "";
    @SerializedName(ServiceConstants.OVERVIEW_PARAGRAPH)
    protected String overviewParagraph = "";
    @SerializedName(ServiceConstants.ADDTL_INFO1)
    protected String additionalInfo = "";
    @SerializedName(ServiceConstants.SHARED_SPACE)
    protected String sharedSpace = "";
    @SerializedName(ServiceConstants.PRIMARY_ADDRESS_LINE_1)
    protected String primaryAddressLine = "";
    @SerializedName(ServiceConstants.CITY)
    protected String city = "";
    @SerializedName(ServiceConstants.STATE_CODE)
    protected String state_code = "";
    @SerializedName(ServiceConstants.POSTCODE)
    protected String postcode = "";
    @SerializedName(ServiceConstants.NEIGHBORHOOD)
    protected String neighborhood = "";
    @SerializedName(ServiceConstants.LATITUDE)
    protected String latitude = "";
    @SerializedName(ServiceConstants.LONGITUDE)
    protected String longitude = "";
    @SerializedName(ServiceConstants.PHONE_NUMBER)
    protected String phoneNumber = "";
    @SerializedName(ServiceConstants.FAX_NUMBER)
    protected String faxNumber = "";
    @SerializedName(ServiceConstants.SCHOOL_EMAIL)
    protected String schoolEmail = "";
    @SerializedName(ServiceConstants.WEBSITE)
    protected String website = "";
    @SerializedName(ServiceConstants.START_TIME)
    protected String startTime = "";
    @SerializedName(ServiceConstants.END_TIME)
    protected String endTime = "";
    @SerializedName(ServiceConstants.SUBWAY)
    protected String subwayLines = "";
    @SerializedName(ServiceConstants.BUS)
    protected String busLines = "";
    @SerializedName(ServiceConstants.TOTAL_STUDENTS)
    protected Integer totalStudents;
    @SerializedName(ServiceConstants.EXTRACURRICULAR_ACTIVITIES)
    protected String extracurricularActivities = "";
    @SerializedName(ServiceConstants.PSAL_SPORTS_BOYS)
    protected String sportsBoys = "";
    @SerializedName(ServiceConstants.PSAL_SPORTS_GIRLS)
    protected String sportsGirls = "";
    @SerializedName(ServiceConstants.PSAL_SPORTS_COED)
    protected String sportsCoed = "";
    @SerializedName(ServiceConstants.SCHOOL_SPORTS)
    protected String schoolSports = "";
    @SerializedName(ServiceConstants.GRADUATION_RATE)
    protected Double graduationRatePercentage;
    @SerializedName(ServiceConstants.PCT_STU_ENOUGH_VARIETY)
    protected Double varietySatisfactionPercentage;
    @SerializedName(ServiceConstants.GIRLS)
    protected Boolean girlsOnly;
    @SerializedName(ServiceConstants.BOYS)
    protected Boolean boysOnly;
    @SerializedName(ServiceConstants.PCT_STU_SAFE)
    protected Double studentSafetyPercentage;
    @SerializedName(ServiceConstants.SCHOOL_ACCESSIBILITY_DESCRIPTION)
    protected String schoolAccessibilityDescription = "";
    @SerializedName(ServiceConstants.LANGUAGE_CLASSES)
    protected String languageClasses = "";
    @SerializedName(ServiceConstants.ADVANCEDPLACEMENT_COURSES)
    protected String advancedPlacementCourses = "";
    @SerializedName(ServiceConstants.DIPLOMAENDORSEMENTS)
    protected String diplomaEndorsements = "";

    @SerializedName(ServiceConstants.INTERNATIONAL)
    protected Boolean isInternational;
    @SerializedName(ServiceConstants.SPECIALIZED)
    protected Boolean isSpecialized;
    @SerializedName(ServiceConstants.TRANSFER)
    protected Boolean isTransfer;
    @SerializedName(ServiceConstants.PTECH)
    protected Boolean isPtech;
    @SerializedName(ServiceConstants.EARLYCOLLEGE)
    protected Boolean isEarlyCollegeSchool;
    @SerializedName(ServiceConstants.GEOELIGIBILITY)
    protected String geographicEligibility = "";

    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES1)
    protected String academicOpportunities1 = "";
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES2)
    protected String academicOpportunities2 = "";
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES3)
    protected String academicOpportunities3 = "";
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES4)
    protected String academicOpportunities4 = "";
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES5)
    protected String academicOpportunities5 = "";

    @SerializedName(ServiceConstants.INTEREST1)
    protected String interest1 = "";
    @SerializedName(ServiceConstants.INTEREST2)
    protected String interest2 = "";
    @SerializedName(ServiceConstants.INTEREST3)
    protected String interest3 = "";
    @SerializedName(ServiceConstants.INTEREST4)
    protected String interest4 = "";
    @SerializedName(ServiceConstants.INTEREST5)
    protected String interest5 = "";
    @SerializedName(ServiceConstants.INTEREST6)
    protected String interest6 = "";
    @SerializedName(ServiceConstants.INTEREST7)
    protected String interest7 = "";
    @SerializedName(ServiceConstants.INTEREST8)
    protected String interest8 = "";
    @SerializedName(ServiceConstants.INTEREST9)
    protected String interest9 = "";
    @SerializedName(ServiceConstants.INTEREST10)
    protected String interest10 = "";

    @SerializedName(ServiceConstants.PROGRAM1)
    protected String program1 = "";
    @SerializedName(ServiceConstants.PROGRAM2)
    protected String program2 = "";
    @SerializedName(ServiceConstants.PROGRAM3)
    protected String program3 = "";
    @SerializedName(ServiceConstants.PROGRAM4)
    protected String program4 = "";
    @SerializedName(ServiceConstants.PROGRAM5)
    protected String program5 = "";
    @SerializedName(ServiceConstants.PROGRAM6)
    protected String program6 = "";
    @SerializedName(ServiceConstants.PROGRAM7)
    protected String program7 = "";
    @SerializedName(ServiceConstants.PROGRAM8)
    protected String program8 = "";
    @SerializedName(ServiceConstants.PROGRAM9)
    protected String program9 = "";
    @SerializedName(ServiceConstants.PROGRAM10)
    protected String program10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_1)
    protected String requirement1_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_2)
    protected String requirement1_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_3)
    protected String requirement1_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_4)
    protected String requirement1_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_5)
    protected String requirement1_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_6)
    protected String requirement1_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_7)
    protected String requirement1_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_8)
    protected String requirement1_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_9)
    protected String requirement1_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT1_10)
    protected String requirement1_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_1)
    protected String requirement2_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_2)
    protected String requirement2_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_3)
    protected String requirement2_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_4)
    protected String requirement2_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_5)
    protected String requirement2_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_6)
    protected String requirement2_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_7)
    protected String requirement2_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_8)
    protected String requirement2_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_9)
    protected String requirement2_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT2_10)
    protected String requirement2_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_1)
    protected String requirement3_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_2)
    protected String requirement3_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_3)
    protected String requirement3_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_4)
    protected String requirement3_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_5)
    protected String requirement3_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_6)
    protected String requirement3_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_7)
    protected String requirement3_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_8)
    protected String requirement3_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_9)
    protected String requirement3_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT3_10)
    protected String requirement3_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_1)
    protected String requirement4_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_2)
    protected String requirement4_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_3)
    protected String requirement4_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_4)
    protected String requirement4_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_5)
    protected String requirement4_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_6)
    protected String requirement4_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_7)
    protected String requirement4_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_8)
    protected String requirement4_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_9)
    protected String requirement4_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT4_10)
    protected String requirement4_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_1)
    protected String requirement5_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_2)
    protected String requirement5_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_3)
    protected String requirement5_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_4)
    protected String requirement5_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_5)
    protected String requirement5_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_6)
    protected String requirement5_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_7)
    protected String requirement5_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_8)
    protected String requirement5_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_9)
    protected String requirement5_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT5_10)
    protected String requirement5_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_1)
    protected String requirement6_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_2)
    protected String requirement6_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_3)
    protected String requirement6_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_4)
    protected String requirement6_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_5)
    protected String requirement6_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_6)
    protected String requirement6_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_7)
    protected String requirement6_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_8)
    protected String requirement6_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_9)
    protected String requirement6_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT6_10)
    protected String requirement6_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_1)
    protected String requirement7_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_2)
    protected String requirement7_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_3)
    protected String requirement7_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_4)
    protected String requirement7_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_5)
    protected String requirement7_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_6)
    protected String requirement7_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_7)
    protected String requirement7_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_8)
    protected String requirement7_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_9)
    protected String requirement7_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT7_10)
    protected String requirement7_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_1)
    protected String requirement8_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_2)
    protected String requirement8_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_3)
    protected String requirement8_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_4)
    protected String requirement8_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_5)
    protected String requirement8_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_6)
    protected String requirement8_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_7)
    protected String requirement8_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_8)
    protected String requirement8_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_9)
    protected String requirement8_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT8_10)
    protected String requirement8_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_1)
    protected String requirement9_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_2)
    protected String requirement9_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_3)
    protected String requirement9_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_4)
    protected String requirement9_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_5)
    protected String requirement9_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_6)
    protected String requirement9_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_7)
    protected String requirement9_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_8)
    protected String requirement9_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_9)
    protected String requirement9_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT9_10)
    protected String requirement9_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_1)
    protected String requirement10_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_2)
    protected String requirement10_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_3)
    protected String requirement10_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_4)
    protected String requirement10_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_5)
    protected String requirement10_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_6)
    protected String requirement10_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_7)
    protected String requirement10_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_8)
    protected String requirement10_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_9)
    protected String requirement10_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT10_10)
    protected String requirement10_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_1)
    protected String requirement11_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_2)
    protected String requirement11_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_3)
    protected String requirement11_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_4)
    protected String requirement11_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_5)
    protected String requirement11_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_6)
    protected String requirement11_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_7)
    protected String requirement11_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_8)
    protected String requirement11_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_9)
    protected String requirement11_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT11_10)
    protected String requirement11_10 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_1)
    protected String requirement12_1 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_2)
    protected String requirement12_2 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_3)
    protected String requirement12_3 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_4)
    protected String requirement12_4 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_5)
    protected String requirement12_5 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_6)
    protected String requirement12_6 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_7)
    protected String requirement12_7 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_8)
    protected String requirement12_8 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_9)
    protected String requirement12_9 = "";
    @SerializedName(ServiceConstants.REQUIREMENT12_10)
    protected String requirement12_10 = "";

    @SerializedName(ServiceConstants.ELIGIBILITY1)
    protected String eligibility1 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY2)
    protected String eligibility2 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY3)
    protected String eligibility3 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY4)
    protected String eligibility4 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY5)
    protected String eligibility5 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY6)
    protected String eligibility6 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY7)
    protected String eligibility7 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY8)
    protected String eligibility8 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY9)
    protected String eligibility9 = "";
    @SerializedName(ServiceConstants.ELIGIBILITY10)
    protected String eligibility10 = "";

    @SerializedName(ServiceConstants.SAT_CRITICAL_READING_AVG_SCORE)
    protected Integer avgACTScoreForReading;
    @SerializedName(ServiceConstants.SAT_WRITING_AVG_SCORE)
    protected Integer avgACTScoreForWriting;
    @SerializedName(ServiceConstants.SAT_MATH_AVG_SCORE)
    protected Integer avgACTScoreForMath;

    public SchoolData() {}

    public String getDbn() {
        return dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getSharedSpace() {
        return sharedSpace;
    }

    public String getAcademicOpportunities1() {
        return academicOpportunities1;
    }

    public String getAcademicOpportunities2() {
        return academicOpportunities2;
    }

    public String getAcademicOpportunities3() {
        return academicOpportunities3;
    }

    public String getAcademicOpportunities4() {
        return academicOpportunities4;
    }

    public String getAcademicOpportunities5() {
        return academicOpportunities5;
    }

    public String getPrimaryAddressLine() {
        return primaryAddressLine;
    }

    public String getCity() {
        return city;
    }

    public String getStateCode() {
        return state_code;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public String getWebsite() {
        return website;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getSubwayLines() {
        return subwayLines;
    }

    public String getBusLines() {
        return busLines;
    }

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public String getSportsBoys() {
        return sportsBoys;
    }

    public String getSportsGirls() {
        return sportsGirls;
    }

    public String getSportsCoed() {
        return sportsCoed;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public Double getGraduationRatePercentage() {
        return graduationRatePercentage;
    }

    public Double getVarietySatisfactionPercentage() {
        return varietySatisfactionPercentage;
    }

    public Boolean getGirlsOnly() {
        return girlsOnly;
    }

    public Boolean getBoysOnly() {
        return boysOnly;
    }

    public Double getStudentSafetyPercentage() {
        return studentSafetyPercentage;
    }

    public String getSchoolAccessibilityDescription() {
        return schoolAccessibilityDescription;
    }

    public String getLanguageClasses() {
        return languageClasses;
    }

    public String getAdvancedPlacementCourses() {
        return advancedPlacementCourses;
    }

    public String getDiplomaEndorsements() {
        return diplomaEndorsements;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public Boolean getSpecialized() {
        return isSpecialized;
    }

    public Boolean getTransfer() {
        return isTransfer;
    }

    public Boolean getPtech() {
        return isPtech;
    }

    public Boolean getEarlyCollegeSchool() {
        return isEarlyCollegeSchool;
    }

    public String getGeographicEligibility() {
        return geographicEligibility;
    }

    public String getInterest1() {
        return interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public String getInterest4() {
        return interest4;
    }

    public String getInterest5() {
        return interest5;
    }

    public String getInterest6() {
        return interest6;
    }

    public String getInterest7() {
        return interest7;
    }

    public String getInterest8() {
        return interest8;
    }

    public String getInterest9() {
        return interest9;
    }

    public String getInterest10() {
        return interest10;
    }

    public String getProgram1() {
        return program1;
    }

    public String getProgram2() {
        return program2;
    }

    public String getProgram3() {
        return program3;
    }

    public String getProgram4() {
        return program4;
    }

    public String getProgram5() {
        return program5;
    }

    public String getProgram6() {
        return program6;
    }

    public String getProgram7() {
        return program7;
    }

    public String getProgram8() {
        return program8;
    }

    public String getProgram9() {
        return program9;
    }

    public String getProgram10() {
        return program10;
    }

    public String getRequirement1_1() {
        return requirement1_1;
    }

    public String getRequirement1_2() {
        return requirement1_2;
    }

    public String getRequirement1_3() {
        return requirement1_3;
    }

    public String getRequirement1_4() {
        return requirement1_4;
    }

    public String getRequirement1_5() {
        return requirement1_5;
    }

    public String getRequirement1_6() {
        return requirement1_6;
    }

    public String getRequirement1_7() {
        return requirement1_7;
    }

    public String getRequirement1_8() {
        return requirement1_8;
    }

    public String getRequirement1_9() {
        return requirement1_9;
    }

    public String getRequirement1_10() {
        return requirement1_10;
    }

    public String getRequirement2_1() {
        return requirement2_1;
    }

    public String getRequirement2_2() {
        return requirement2_2;
    }

    public String getRequirement2_3() {
        return requirement2_3;
    }

    public String getRequirement2_4() {
        return requirement2_4;
    }

    public String getRequirement2_5() {
        return requirement2_5;
    }

    public String getRequirement2_6() {
        return requirement2_6;
    }

    public String getRequirement2_7() {
        return requirement2_7;
    }

    public String getRequirement2_8() {
        return requirement2_8;
    }

    public String getRequirement2_9() {
        return requirement2_9;
    }

    public String getRequirement2_10() {
        return requirement2_10;
    }

    public String getRequirement3_1() {
        return requirement3_1;
    }

    public String getRequirement3_2() {
        return requirement3_2;
    }

    public String getRequirement3_3() {
        return requirement3_3;
    }

    public String getRequirement3_4() {
        return requirement3_4;
    }

    public String getRequirement3_5() {
        return requirement3_5;
    }

    public String getRequirement3_6() {
        return requirement3_6;
    }

    public String getRequirement3_7() {
        return requirement3_7;
    }

    public String getRequirement3_8() {
        return requirement3_8;
    }

    public String getRequirement3_9() {
        return requirement3_9;
    }

    public String getRequirement3_10() {
        return requirement3_10;
    }

    public String getRequirement4_1() {
        return requirement4_1;
    }

    public String getRequirement4_2() {
        return requirement4_2;
    }

    public String getRequirement4_3() {
        return requirement4_3;
    }

    public String getRequirement4_4() {
        return requirement4_4;
    }

    public String getRequirement4_5() {
        return requirement4_5;
    }

    public String getRequirement4_6() {
        return requirement4_6;
    }

    public String getRequirement4_7() {
        return requirement4_7;
    }

    public String getRequirement4_8() {
        return requirement4_8;
    }

    public String getRequirement4_9() {
        return requirement4_9;
    }

    public String getRequirement4_10() {
        return requirement4_10;
    }

    public String getRequirement5_1() {
        return requirement5_1;
    }

    public String getRequirement5_2() {
        return requirement5_2;
    }

    public String getRequirement5_3() {
        return requirement5_3;
    }

    public String getRequirement5_4() {
        return requirement5_4;
    }

    public String getRequirement5_5() {
        return requirement5_5;
    }

    public String getRequirement5_6() {
        return requirement5_6;
    }

    public String getRequirement5_7() {
        return requirement5_7;
    }

    public String getRequirement5_8() {
        return requirement5_8;
    }

    public String getRequirement5_9() {
        return requirement5_9;
    }

    public String getRequirement5_10() {
        return requirement5_10;
    }

    public String getRequirement6_1() {
        return requirement6_1;
    }

    public String getRequirement6_2() {
        return requirement6_2;
    }

    public String getRequirement6_3() {
        return requirement6_3;
    }

    public String getRequirement6_4() {
        return requirement6_4;
    }

    public String getRequirement6_5() {
        return requirement6_5;
    }

    public String getRequirement6_6() {
        return requirement6_6;
    }

    public String getRequirement6_7() {
        return requirement6_7;
    }

    public String getRequirement6_8() {
        return requirement6_8;
    }

    public String getRequirement6_9() {
        return requirement6_9;
    }

    public String getRequirement6_10() {
        return requirement6_10;
    }

    public String getRequirement7_1() {
        return requirement7_1;
    }

    public String getRequirement7_2() {
        return requirement7_2;
    }

    public String getRequirement7_3() {
        return requirement7_3;
    }

    public String getRequirement7_4() {
        return requirement7_4;
    }

    public String getRequirement7_5() {
        return requirement7_5;
    }

    public String getRequirement7_6() {
        return requirement7_6;
    }

    public String getRequirement7_7() {
        return requirement7_7;
    }

    public String getRequirement7_8() {
        return requirement7_8;
    }

    public String getRequirement7_9() {
        return requirement7_9;
    }

    public String getRequirement7_10() {
        return requirement7_10;
    }

    public String getRequirement8_1() {
        return requirement8_1;
    }

    public String getRequirement8_2() {
        return requirement8_2;
    }

    public String getRequirement8_3() {
        return requirement8_3;
    }

    public String getRequirement8_4() {
        return requirement8_4;
    }

    public String getRequirement8_5() {
        return requirement8_5;
    }

    public String getRequirement8_6() {
        return requirement8_6;
    }

    public String getRequirement8_7() {
        return requirement8_7;
    }

    public String getRequirement8_8() {
        return requirement8_8;
    }

    public String getRequirement8_9() {
        return requirement8_9;
    }

    public String getRequirement8_10() {
        return requirement8_10;
    }

    public String getRequirement9_1() {
        return requirement9_1;
    }

    public String getRequirement9_2() {
        return requirement9_2;
    }

    public String getRequirement9_3() {
        return requirement9_3;
    }

    public String getRequirement9_4() {
        return requirement9_4;
    }

    public String getRequirement9_5() {
        return requirement9_5;
    }

    public String getRequirement9_6() {
        return requirement9_6;
    }

    public String getRequirement9_7() {
        return requirement9_7;
    }

    public String getRequirement9_8() {
        return requirement9_8;
    }

    public String getRequirement9_9() {
        return requirement9_9;
    }

    public String getRequirement9_10() {
        return requirement9_10;
    }

    public String getRequirement10_1() {
        return requirement10_1;
    }

    public String getRequirement10_2() {
        return requirement10_2;
    }

    public String getRequirement10_3() {
        return requirement10_3;
    }

    public String getRequirement10_4() {
        return requirement10_4;
    }

    public String getRequirement10_5() {
        return requirement10_5;
    }

    public String getRequirement10_6() {
        return requirement10_6;
    }

    public String getRequirement10_7() {
        return requirement10_7;
    }

    public String getRequirement10_8() {
        return requirement10_8;
    }

    public String getRequirement10_9() {
        return requirement10_9;
    }

    public String getRequirement10_10() {
        return requirement10_10;
    }

    public String getRequirement11_1() {
        return requirement11_1;
    }

    public String getRequirement11_2() {
        return requirement11_2;
    }

    public String getRequirement11_3() {
        return requirement11_3;
    }

    public String getRequirement11_4() {
        return requirement11_4;
    }

    public String getRequirement11_5() {
        return requirement11_5;
    }

    public String getRequirement11_6() {
        return requirement11_6;
    }

    public String getRequirement11_7() {
        return requirement11_7;
    }

    public String getRequirement11_8() {
        return requirement11_8;
    }

    public String getRequirement11_9() {
        return requirement11_9;
    }

    public String getRequirement11_10() {
        return requirement11_10;
    }

    public String getRequirement12_1() {
        return requirement12_1;
    }

    public String getRequirement12_2() {
        return requirement12_2;
    }

    public String getRequirement12_3() {
        return requirement12_3;
    }

    public String getRequirement12_4() {
        return requirement12_4;
    }

    public String getRequirement12_5() {
        return requirement12_5;
    }

    public String getRequirement12_6() {
        return requirement12_6;
    }

    public String getRequirement12_7() {
        return requirement12_7;
    }

    public String getRequirement12_8() {
        return requirement12_8;
    }

    public String getRequirement12_9() {
        return requirement12_9;
    }

    public String getRequirement12_10() {
        return requirement12_10;
    }

    public String getEligibility1() {
        return eligibility1;
    }

    public String getEligibility2() {
        return eligibility2;
    }

    public String getEligibility3() {
        return eligibility3;
    }

    public String getEligibility4() {
        return eligibility4;
    }

    public String getEligibility5() {
        return eligibility5;
    }

    public String getEligibility6() {
        return eligibility6;
    }

    public String getEligibility7() {
        return eligibility7;
    }

    public String getEligibility8() {
        return eligibility8;
    }

    public String getEligibility9() {
        return eligibility9;
    }

    public String getEligibility10() {
        return eligibility10;
    }

    @Override
    public Integer getSATForReading() {
        return avgACTScoreForReading;
    }

    @Override
    public void setSATForReading(Integer value) {
        this.avgACTScoreForReading = value;
    }

    @Override
    public Integer getSATForWriting() {
        return avgACTScoreForWriting;
    }

    @Override
    public void setSATForWriting(Integer value) {
        this.avgACTScoreForWriting = value;
    }

    @Override
    public Integer getSATForMath() {
        return avgACTScoreForMath;
    }

    @Override
    public void setSATForMath(Integer value) {
        this.avgACTScoreForMath = value;
    }
}
