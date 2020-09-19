package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts;

import com.google.gson.annotations.SerializedName;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.utils.ServiceConstants;

import java.io.Serializable;

public interface ISchoolData extends Serializable {
    @SerializedName(ServiceConstants.DBN)
    String getDbn();
    @SerializedName(ServiceConstants.SCHOOL_NAME)
    String getSchoolName();
    @SerializedName(ServiceConstants.OVERVIEW_PARAGRAPH)
    String getOverviewParagraph();
    @SerializedName(ServiceConstants.ADDTL_INFO1)
    String getAdditionalInfo();
    @SerializedName(ServiceConstants.SHARED_SPACE)
    String getSharedSpace();
    @SerializedName(ServiceConstants.PRIMARY_ADDRESS_LINE_1)
    String getAcademicOpportunities1();
    @SerializedName(ServiceConstants.CITY)
    String getAcademicOpportunities2();
    @SerializedName(ServiceConstants.STATE_CODE)
    String getAcademicOpportunities3();
    @SerializedName(ServiceConstants.POSTCODE)
    String getAcademicOpportunities4();
    @SerializedName(ServiceConstants.NEIGHBORHOOD)
    String getAcademicOpportunities5();
    @SerializedName(ServiceConstants.LATITUDE)
    String getPrimaryAddressLine();
    @SerializedName(ServiceConstants.LONGITUDE)
    String getCity();
    @SerializedName(ServiceConstants.PHONE_NUMBER)
    String getStateCode();
    @SerializedName(ServiceConstants.FAX_NUMBER)
    String getPostcode();
    @SerializedName(ServiceConstants.SCHOOL_EMAIL)
    String getNeighborhood();
    @SerializedName(ServiceConstants.WEBSITE)
    String getLatitude();
    @SerializedName(ServiceConstants.START_TIME)
    String getLongitude();
    @SerializedName(ServiceConstants.END_TIME)
    String getPhoneNumber();
    @SerializedName(ServiceConstants.SUBWAY)
    String getFaxNumber();
    @SerializedName(ServiceConstants.BUS)
    String getSchoolEmail();
    @SerializedName(ServiceConstants.TOTAL_STUDENTS)
    String getWebsite();
    @SerializedName(ServiceConstants.EXTRACURRICULAR_ACTIVITIES)
    String getStartTime();
    @SerializedName(ServiceConstants.PSAL_SPORTS_BOYS)
    String getEndTime();
    @SerializedName(ServiceConstants.PSAL_SPORTS_GIRLS)
    String getSubwayLines();
    @SerializedName(ServiceConstants.PSAL_SPORTS_COED)
    String getBusLines();
    @SerializedName(ServiceConstants.SCHOOL_SPORTS)
    Integer getTotalStudents();
    @SerializedName(ServiceConstants.GRADUATION_RATE)
    String getExtracurricularActivities();
    @SerializedName(ServiceConstants.PCT_STU_ENOUGH_VARIETY)
    String getSportsBoys();
    @SerializedName(ServiceConstants.GIRLS)
    String getSportsGirls();
    @SerializedName(ServiceConstants.BOYS)
    String getSportsCoed();
    @SerializedName(ServiceConstants.PCT_STU_SAFE)
    String getSchoolSports();
    @SerializedName(ServiceConstants.SCHOOL_ACCESSIBILITY_DESCRIPTION)
    Double getGraduationRatePercentage();
    @SerializedName(ServiceConstants.LANGUAGE_CLASSES)
    Double getVarietySatisfactionPercentage();
    @SerializedName(ServiceConstants.ADVANCEDPLACEMENT_COURSES)
    Boolean getGirlsOnly();
    @SerializedName(ServiceConstants.DIPLOMAENDORSEMENTS)
    Boolean getBoysOnly();
    @SerializedName(ServiceConstants.INTERNATIONAL)
    Double getStudentSafetyPercentage();
    @SerializedName(ServiceConstants.SPECIALIZED)
    String getSchoolAccessibilityDescription();
    @SerializedName(ServiceConstants.TRANSFER)
    String getLanguageClasses();
    @SerializedName(ServiceConstants.PTECH)
    String getAdvancedPlacementCourses();
    @SerializedName(ServiceConstants.EARLYCOLLEGE)
    String getDiplomaEndorsements();
    @SerializedName(ServiceConstants.GEOELIGIBILITY)
    Boolean getInternational();
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES1)
    Boolean getSpecialized();
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES2)
    Boolean getTransfer();
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES3)
    Boolean getPtech();
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES4)
    Boolean getEarlyCollegeSchool();
    @SerializedName(ServiceConstants.ACADEMICOPPORTUNITIES5)
    String getGeographicEligibility();
    @SerializedName(ServiceConstants.INTEREST1)
    String getInterest1();
    @SerializedName(ServiceConstants.INTEREST2)
    String getInterest2();
    @SerializedName(ServiceConstants.INTEREST3)
    String getInterest3();
    @SerializedName(ServiceConstants.INTEREST4)
    String getInterest4();
    @SerializedName(ServiceConstants.INTEREST5)
    String getInterest5();
    @SerializedName(ServiceConstants.INTEREST6)
    String getInterest6();
    @SerializedName(ServiceConstants.INTEREST7)
    String getInterest7();
    @SerializedName(ServiceConstants.INTEREST8)
    String getInterest8();
    @SerializedName(ServiceConstants.INTEREST9)
    String getInterest9();
    @SerializedName(ServiceConstants.INTEREST10)
    String getInterest10();
    @SerializedName(ServiceConstants.PROGRAM1)
    String getProgram1();
    @SerializedName(ServiceConstants.PROGRAM2)
    String getProgram2();
    @SerializedName(ServiceConstants.PROGRAM3)
    String getProgram3();
    @SerializedName(ServiceConstants.PROGRAM4)
    String getProgram4();
    @SerializedName(ServiceConstants.PROGRAM5)
    String getProgram5();
    @SerializedName(ServiceConstants.PROGRAM6)
    String getProgram6();
    @SerializedName(ServiceConstants.PROGRAM7)
    String getProgram7();
    @SerializedName(ServiceConstants.PROGRAM8)
    String getProgram8();
    @SerializedName(ServiceConstants.PROGRAM9)
    String getProgram9();
    @SerializedName(ServiceConstants.PROGRAM10)
    String getProgram10();
    @SerializedName(ServiceConstants.REQUIREMENT1_1)
    String getRequirement1_1();
    @SerializedName(ServiceConstants.REQUIREMENT1_2)
    String getRequirement1_2();
    @SerializedName(ServiceConstants.REQUIREMENT1_3)
    String getRequirement1_3();
    @SerializedName(ServiceConstants.REQUIREMENT1_4)
    String getRequirement1_4();
    @SerializedName(ServiceConstants.REQUIREMENT1_5)
    String getRequirement1_5();
    @SerializedName(ServiceConstants.REQUIREMENT1_6)
    String getRequirement1_6();
    @SerializedName(ServiceConstants.REQUIREMENT1_7)
    String getRequirement1_7();
    @SerializedName(ServiceConstants.REQUIREMENT1_8)
    String getRequirement1_8();
    @SerializedName(ServiceConstants.REQUIREMENT1_9)
    String getRequirement1_9();
    @SerializedName(ServiceConstants.REQUIREMENT1_10)
    String getRequirement1_10();
    @SerializedName(ServiceConstants.REQUIREMENT2_1)
    String getRequirement2_1();
    @SerializedName(ServiceConstants.REQUIREMENT2_2)
    String getRequirement2_2();
    @SerializedName(ServiceConstants.REQUIREMENT2_3)
    String getRequirement2_3();
    @SerializedName(ServiceConstants.REQUIREMENT2_4)
    String getRequirement2_4();
    @SerializedName(ServiceConstants.REQUIREMENT2_5)
    String getRequirement2_5();
    @SerializedName(ServiceConstants.REQUIREMENT2_6)
    String getRequirement2_6();
    @SerializedName(ServiceConstants.REQUIREMENT2_7)
    String getRequirement2_7();
    @SerializedName(ServiceConstants.REQUIREMENT2_8)
    String getRequirement2_8();
    @SerializedName(ServiceConstants.REQUIREMENT2_9)
    String getRequirement2_9();
    @SerializedName(ServiceConstants.REQUIREMENT2_10)
    String getRequirement2_10();
    @SerializedName(ServiceConstants.REQUIREMENT3_1)
    String getRequirement3_1();
    @SerializedName(ServiceConstants.REQUIREMENT3_2)
    String getRequirement3_2();
    @SerializedName(ServiceConstants.REQUIREMENT3_3)
    String getRequirement3_3();
    @SerializedName(ServiceConstants.REQUIREMENT3_4)
    String getRequirement3_4();
    @SerializedName(ServiceConstants.REQUIREMENT3_5)
    String getRequirement3_5();
    @SerializedName(ServiceConstants.REQUIREMENT3_6)
    String getRequirement3_6();
    @SerializedName(ServiceConstants.REQUIREMENT3_7)
    String getRequirement3_7();
    @SerializedName(ServiceConstants.REQUIREMENT3_8)
    String getRequirement3_8();
    @SerializedName(ServiceConstants.REQUIREMENT3_9)
    String getRequirement3_9();
    @SerializedName(ServiceConstants.REQUIREMENT3_10)
    String getRequirement3_10();
    @SerializedName(ServiceConstants.REQUIREMENT4_1)
    String getRequirement4_1();
    @SerializedName(ServiceConstants.REQUIREMENT4_2)
    String getRequirement4_2();
    @SerializedName(ServiceConstants.REQUIREMENT4_3)
    String getRequirement4_3();
    @SerializedName(ServiceConstants.REQUIREMENT4_4)
    String getRequirement4_4();
    @SerializedName(ServiceConstants.REQUIREMENT4_5)
    String getRequirement4_5();
    @SerializedName(ServiceConstants.REQUIREMENT4_6)
    String getRequirement4_6();
    @SerializedName(ServiceConstants.REQUIREMENT4_7)
    String getRequirement4_7();
    @SerializedName(ServiceConstants.REQUIREMENT4_8)
    String getRequirement4_8();
    @SerializedName(ServiceConstants.REQUIREMENT4_9)
    String getRequirement4_9();
    @SerializedName(ServiceConstants.REQUIREMENT4_10)
    String getRequirement4_10();
    @SerializedName(ServiceConstants.REQUIREMENT5_1)
    String getRequirement5_1();
    @SerializedName(ServiceConstants.REQUIREMENT5_2)
    String getRequirement5_2();
    @SerializedName(ServiceConstants.REQUIREMENT5_3)
    String getRequirement5_3();
    @SerializedName(ServiceConstants.REQUIREMENT5_4)
    String getRequirement5_4();
    @SerializedName(ServiceConstants.REQUIREMENT5_5)
    String getRequirement5_5();
    @SerializedName(ServiceConstants.REQUIREMENT5_6)
    String getRequirement5_6();
    @SerializedName(ServiceConstants.REQUIREMENT5_7)
    String getRequirement5_7();
    @SerializedName(ServiceConstants.REQUIREMENT5_8)
    String getRequirement5_8();
    @SerializedName(ServiceConstants.REQUIREMENT5_9)
    String getRequirement5_9();
    @SerializedName(ServiceConstants.REQUIREMENT5_10)
    String getRequirement5_10();
    @SerializedName(ServiceConstants.REQUIREMENT6_1)
    String getRequirement6_1();
    @SerializedName(ServiceConstants.REQUIREMENT6_2)
    String getRequirement6_2();
    @SerializedName(ServiceConstants.REQUIREMENT6_3)
    String getRequirement6_3();
    @SerializedName(ServiceConstants.REQUIREMENT6_4)
    String getRequirement6_4();
    @SerializedName(ServiceConstants.REQUIREMENT6_5)
    String getRequirement6_5();
    @SerializedName(ServiceConstants.REQUIREMENT6_6)
    String getRequirement6_6();
    @SerializedName(ServiceConstants.REQUIREMENT6_7)
    String getRequirement6_7();
    @SerializedName(ServiceConstants.REQUIREMENT6_8)
    String getRequirement6_8();
    @SerializedName(ServiceConstants.REQUIREMENT6_9)
    String getRequirement6_9();
    @SerializedName(ServiceConstants.REQUIREMENT6_10)
    String getRequirement6_10();
    @SerializedName(ServiceConstants.REQUIREMENT7_1)
    String getRequirement7_1();
    @SerializedName(ServiceConstants.REQUIREMENT7_2)
    String getRequirement7_2();
    @SerializedName(ServiceConstants.REQUIREMENT7_3)
    String getRequirement7_3();
    @SerializedName(ServiceConstants.REQUIREMENT7_4)
    String getRequirement7_4();
    @SerializedName(ServiceConstants.REQUIREMENT7_5)
    String getRequirement7_5();
    @SerializedName(ServiceConstants.REQUIREMENT7_6)
    String getRequirement7_6();
    @SerializedName(ServiceConstants.REQUIREMENT7_7)
    String getRequirement7_7();
    @SerializedName(ServiceConstants.REQUIREMENT7_8)
    String getRequirement7_8();
    @SerializedName(ServiceConstants.REQUIREMENT7_9)
    String getRequirement7_9();
    @SerializedName(ServiceConstants.REQUIREMENT7_10)
    String getRequirement7_10();
    @SerializedName(ServiceConstants.REQUIREMENT8_1)
    String getRequirement8_1();
    @SerializedName(ServiceConstants.REQUIREMENT8_2)
    String getRequirement8_2();
    @SerializedName(ServiceConstants.REQUIREMENT8_3)
    String getRequirement8_3();
    @SerializedName(ServiceConstants.REQUIREMENT8_4)
    String getRequirement8_4();
    @SerializedName(ServiceConstants.REQUIREMENT8_5)
    String getRequirement8_5();
    @SerializedName(ServiceConstants.REQUIREMENT8_6)
    String getRequirement8_6();
    @SerializedName(ServiceConstants.REQUIREMENT8_7)
    String getRequirement8_7();
    @SerializedName(ServiceConstants.REQUIREMENT8_8)
    String getRequirement8_8();
    @SerializedName(ServiceConstants.REQUIREMENT8_9)
    String getRequirement8_9();
    @SerializedName(ServiceConstants.REQUIREMENT8_10)
    String getRequirement8_10();
    @SerializedName(ServiceConstants.REQUIREMENT9_1)
    String getRequirement9_1();
    @SerializedName(ServiceConstants.REQUIREMENT9_2)
    String getRequirement9_2();
    @SerializedName(ServiceConstants.REQUIREMENT9_3)
    String getRequirement9_3();
    @SerializedName(ServiceConstants.REQUIREMENT9_4)
    String getRequirement9_4();
    @SerializedName(ServiceConstants.REQUIREMENT9_5)
    String getRequirement9_5();
    @SerializedName(ServiceConstants.REQUIREMENT9_6)
    String getRequirement9_6();
    @SerializedName(ServiceConstants.REQUIREMENT9_7)
    String getRequirement9_7();
    @SerializedName(ServiceConstants.REQUIREMENT9_8)
    String getRequirement9_8();
    @SerializedName(ServiceConstants.REQUIREMENT9_9)
    String getRequirement9_9();
    @SerializedName(ServiceConstants.REQUIREMENT9_10)
    String getRequirement9_10();
    @SerializedName(ServiceConstants.REQUIREMENT10_1)
    String getRequirement10_1();
    @SerializedName(ServiceConstants.REQUIREMENT10_2)
    String getRequirement10_2();
    @SerializedName(ServiceConstants.REQUIREMENT10_3)
    String getRequirement10_3();
    @SerializedName(ServiceConstants.REQUIREMENT10_4)
    String getRequirement10_4();
    @SerializedName(ServiceConstants.REQUIREMENT10_5)
    String getRequirement10_5();
    @SerializedName(ServiceConstants.REQUIREMENT10_6)
    String getRequirement10_6();
    @SerializedName(ServiceConstants.REQUIREMENT10_7)
    String getRequirement10_7();
    @SerializedName(ServiceConstants.REQUIREMENT10_8)
    String getRequirement10_8();
    @SerializedName(ServiceConstants.REQUIREMENT10_9)
    String getRequirement10_9();
    @SerializedName(ServiceConstants.REQUIREMENT10_10)
    String getRequirement10_10();
    @SerializedName(ServiceConstants.REQUIREMENT11_1)
    String getRequirement11_1();
    @SerializedName(ServiceConstants.REQUIREMENT11_2)
    String getRequirement11_2();
    @SerializedName(ServiceConstants.REQUIREMENT11_3)
    String getRequirement11_3();
    @SerializedName(ServiceConstants.REQUIREMENT11_4)
    String getRequirement11_4();
    @SerializedName(ServiceConstants.REQUIREMENT11_5)
    String getRequirement11_5();
    @SerializedName(ServiceConstants.REQUIREMENT11_6)
    String getRequirement11_6();
    @SerializedName(ServiceConstants.REQUIREMENT11_7)
    String getRequirement11_7();
    @SerializedName(ServiceConstants.REQUIREMENT11_8)
    String getRequirement11_8();
    @SerializedName(ServiceConstants.REQUIREMENT11_9)
    String getRequirement11_9();
    @SerializedName(ServiceConstants.REQUIREMENT11_10)
    String getRequirement11_10();
    @SerializedName(ServiceConstants.REQUIREMENT12_1)
    String getRequirement12_1();
    @SerializedName(ServiceConstants.REQUIREMENT12_2)
    String getRequirement12_2();
    @SerializedName(ServiceConstants.REQUIREMENT12_3)
    String getRequirement12_3();
    @SerializedName(ServiceConstants.REQUIREMENT12_4)
    String getRequirement12_4();
    @SerializedName(ServiceConstants.REQUIREMENT12_5)
    String getRequirement12_5();
    @SerializedName(ServiceConstants.REQUIREMENT12_6)
    String getRequirement12_6();
    @SerializedName(ServiceConstants.REQUIREMENT12_7)
    String getRequirement12_7();
    @SerializedName(ServiceConstants.REQUIREMENT12_8)
    String getRequirement12_8();
    @SerializedName(ServiceConstants.REQUIREMENT12_9)
    String getRequirement12_9();
    @SerializedName(ServiceConstants.REQUIREMENT12_10)
    String getRequirement12_10();
    @SerializedName(ServiceConstants.ELIGIBILITY1)
    String getEligibility1();
    @SerializedName(ServiceConstants.ELIGIBILITY2)
    String getEligibility2();
    @SerializedName(ServiceConstants.ELIGIBILITY3)
    String getEligibility3();
    @SerializedName(ServiceConstants.ELIGIBILITY4)
    String getEligibility4();
    @SerializedName(ServiceConstants.ELIGIBILITY5)
    String getEligibility5();
    @SerializedName(ServiceConstants.ELIGIBILITY6)
    String getEligibility6();
    @SerializedName(ServiceConstants.ELIGIBILITY7)
    String getEligibility7();
    @SerializedName(ServiceConstants.ELIGIBILITY8)
    String getEligibility8();
    @SerializedName(ServiceConstants.ELIGIBILITY9)
    String getEligibility9();
    @SerializedName(ServiceConstants.ELIGIBILITY10)
    String getEligibility10();
    @SerializedName(ServiceConstants.SAT_CRITICAL_READING_AVG_SCORE)
    Integer getSATForReading();
    @SerializedName(ServiceConstants.SAT_CRITICAL_READING_AVG_SCORE)
    void setSATForReading(Integer value);
    @SerializedName(ServiceConstants.SAT_WRITING_AVG_SCORE)
    Integer getSATForWriting();
    @SerializedName(ServiceConstants.SAT_WRITING_AVG_SCORE)
    void setSATForWriting(Integer value);
    @SerializedName(ServiceConstants.SAT_MATH_AVG_SCORE)
    Integer getSATForMath();
    @SerializedName(ServiceConstants.SAT_MATH_AVG_SCORE)
    void setSATForMath(Integer value);
}
