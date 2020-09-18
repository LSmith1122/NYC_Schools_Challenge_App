package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public interface ISchoolData extends Serializable {
    @SerializedName("dbn")
    String getDbn();
    @SerializedName("school_name")
    String getSchoolName();
    @SerializedName("overview_paragraph")
    String getOverviewParagraph();
    @SerializedName("addtl_info1")
    String getAdditionalInfo();
    @SerializedName("shared_space")
    String getSharedSpace();
    @SerializedName("primary_address_line_1")
    String getAcademicOpportunities1();
    @SerializedName("city")
    String getAcademicOpportunities2();
    @SerializedName("state_code")
    String getAcademicOpportunities3();
    @SerializedName("Postcode")
    String getAcademicOpportunities4();
    @SerializedName("neighborhood")
    String getAcademicOpportunities5();
    @SerializedName("Latitude")
    String getPrimaryAddressLine();
    @SerializedName("Longitude")
    String getCity();
    @SerializedName("phone_number")
    String getStateCode();
    @SerializedName("fax_number")
    String getPostcode();
    @SerializedName("school_email")
    String getNeighborhood();
    @SerializedName("website")
    String getLatitude();
    @SerializedName("start_time")
    String getLongitude();
    @SerializedName("end_time")
    String getPhoneNumber();
    @SerializedName("subway")
    String getFaxNumber();
    @SerializedName("bus")
    String getSchoolEmail();
    @SerializedName("total_students")
    String getWebsite();
    @SerializedName("extracurricular_activities")
    String getStartTime();
    @SerializedName("psal_sports_boys")
    String getEndTime();
    @SerializedName("psal_sports_girls")
    String getSubwayLines();
    @SerializedName("psal_sports_coed")
    String getBusLines();
    @SerializedName("school_sports")
    Integer getTotalStudents();
    @SerializedName("graduation_rate")
    String getExtracurricularActivities();
    @SerializedName("pct_stu_enough_variety")
    String getSportsBoys();
    @SerializedName("girls")
    String getSportsGirls();
    @SerializedName("boys")
    String getSportsCoed();
    @SerializedName("pct_stu_safe")
    String getSchoolSports();
    @SerializedName("school_accessibility_description")
    Double getGraduationRatePercentage();
    @SerializedName("language_classes")
    Double getVarietySatisfactionPercentage();
    @SerializedName("advancedplacement_courses")
    Boolean getGirlsOnly();
    @SerializedName("diplomaendorsements")
    Boolean getBoysOnly();
    @SerializedName("international")
    Double getStudentSafetyPercentage();
    @SerializedName("specialized")
    String getSchoolAccessibilityDescription();
    @SerializedName("transfer")
    String getLanguageClasses();
    @SerializedName("ptech")
    String getAdvancedPlacementCourses();
    @SerializedName("earlycollege")
    String getDiplomaEndorsements();
    @SerializedName("geoeligibility")
    Boolean getInternational();
    @SerializedName("academicopportunities1")
    Boolean getSpecialized();
    @SerializedName("academicopportunities2")
    Boolean getTransfer();
    @SerializedName("academicopportunities3")
    Boolean getPtech();
    @SerializedName("academicopportunities4")
    Boolean getEarlyCollegeSchool();
    @SerializedName("academicopportunities5")
    String getGeographicEligibility();
    @SerializedName("interest1")
    String getInterest1();
    @SerializedName("interest2")
    String getInterest2();
    @SerializedName("interest3")
    String getInterest3();
    @SerializedName("interest4")
    String getInterest4();
    @SerializedName("interest5")
    String getInterest5();
    @SerializedName("interest6")
    String getInterest6();
    @SerializedName("interest7")
    String getInterest7();
    @SerializedName("interest8")
    String getInterest8();
    @SerializedName("interest9")
    String getInterest9();
    @SerializedName("interest10")
    String getInterest10();
    @SerializedName("program1")
    String getProgram1();
    @SerializedName("program2")
    String getProgram2();
    @SerializedName("program3")
    String getProgram3();
    @SerializedName("program4")
    String getProgram4();
    @SerializedName("program5")
    String getProgram5();
    @SerializedName("program6")
    String getProgram6();
    @SerializedName("program7")
    String getProgram7();
    @SerializedName("program8")
    String getProgram8();
    @SerializedName("program9")
    String getProgram9();
    @SerializedName("program10")
    String getProgram10();
    @SerializedName("requirement1_1")
    String getRequirement1_1();
    @SerializedName("requirement1_2")
    String getRequirement1_2();
    @SerializedName("requirement1_3")
    String getRequirement1_3();
    @SerializedName("requirement1_4")
    String getRequirement1_4();
    @SerializedName("requirement1_5")
    String getRequirement1_5();
    @SerializedName("requirement1_6")
    String getRequirement1_6();
    @SerializedName("requirement1_7")
    String getRequirement1_7();
    @SerializedName("requirement1_8")
    String getRequirement1_8();
    @SerializedName("requirement1_9")
    String getRequirement1_9();
    @SerializedName("requirement1_10")
    String getRequirement1_10();
    @SerializedName("requirement2_1")
    String getRequirement2_1();
    @SerializedName("requirement2_2")
    String getRequirement2_2();
    @SerializedName("requirement2_3")
    String getRequirement2_3();
    @SerializedName("requirement2_4")
    String getRequirement2_4();
    @SerializedName("requirement2_5")
    String getRequirement2_5();
    @SerializedName("requirement2_6")
    String getRequirement2_6();
    @SerializedName("requirement2_7")
    String getRequirement2_7();
    @SerializedName("requirement2_8")
    String getRequirement2_8();
    @SerializedName("requirement2_9")
    String getRequirement2_9();
    @SerializedName("requirement2_10")
    String getRequirement2_10();
    @SerializedName("requirement3_1")
    String getRequirement3_1();
    @SerializedName("requirement3_2")
    String getRequirement3_2();
    @SerializedName("requirement3_3")
    String getRequirement3_3();
    @SerializedName("requirement3_4")
    String getRequirement3_4();
    @SerializedName("requirement3_5")
    String getRequirement3_5();
    @SerializedName("requirement3_6")
    String getRequirement3_6();
    @SerializedName("requirement3_7")
    String getRequirement3_7();
    @SerializedName("requirement3_8")
    String getRequirement3_8();
    @SerializedName("requirement3_9")
    String getRequirement3_9();
    @SerializedName("requirement3_10")
    String getRequirement3_10();
    @SerializedName("requirement4_1")
    String getRequirement4_1();
    @SerializedName("requirement4_2")
    String getRequirement4_2();
    @SerializedName("requirement4_3")
    String getRequirement4_3();
    @SerializedName("requirement4_4")
    String getRequirement4_4();
    @SerializedName("requirement4_5")
    String getRequirement4_5();
    @SerializedName("requirement4_6")
    String getRequirement4_6();
    @SerializedName("requirement4_7")
    String getRequirement4_7();
    @SerializedName("requirement4_8")
    String getRequirement4_8();
    @SerializedName("requirement4_9")
    String getRequirement4_9();
    @SerializedName("requirement4_10")
    String getRequirement4_10();
    @SerializedName("requirement5_1")
    String getRequirement5_1();
    @SerializedName("requirement5_2")
    String getRequirement5_2();
    @SerializedName("requirement5_3")
    String getRequirement5_3();
    @SerializedName("requirement5_4")
    String getRequirement5_4();
    @SerializedName("requirement5_5")
    String getRequirement5_5();
    @SerializedName("requirement5_6")
    String getRequirement5_6();
    @SerializedName("requirement5_7")
    String getRequirement5_7();
    @SerializedName("requirement5_8")
    String getRequirement5_8();
    @SerializedName("requirement5_9")
    String getRequirement5_9();
    @SerializedName("requirement5_10")
    String getRequirement5_10();
    @SerializedName("requirement6_1")
    String getRequirement6_1();
    @SerializedName("requirement6_2")
    String getRequirement6_2();
    @SerializedName("requirement6_3")
    String getRequirement6_3();
    @SerializedName("requirement6_4")
    String getRequirement6_4();
    @SerializedName("requirement6_5")
    String getRequirement6_5();
    @SerializedName("requirement6_6")
    String getRequirement6_6();
    @SerializedName("requirement6_7")
    String getRequirement6_7();
    @SerializedName("requirement6_8")
    String getRequirement6_8();
    @SerializedName("requirement6_9")
    String getRequirement6_9();
    @SerializedName("requirement6_10")
    String getRequirement6_10();
    @SerializedName("requirement7_1")
    String getRequirement7_1();
    @SerializedName("requirement7_2")
    String getRequirement7_2();
    @SerializedName("requirement7_3")
    String getRequirement7_3();
    @SerializedName("requirement7_4")
    String getRequirement7_4();
    @SerializedName("requirement7_5")
    String getRequirement7_5();
    @SerializedName("requirement7_6")
    String getRequirement7_6();
    @SerializedName("requirement7_7")
    String getRequirement7_7();
    @SerializedName("requirement7_8")
    String getRequirement7_8();
    @SerializedName("requirement7_9")
    String getRequirement7_9();
    @SerializedName("requirement7_10")
    String getRequirement7_10();
    @SerializedName("requirement8_1")
    String getRequirement8_1();
    @SerializedName("requirement8_2")
    String getRequirement8_2();
    @SerializedName("requirement8_3")
    String getRequirement8_3();
    @SerializedName("requirement8_4")
    String getRequirement8_4();
    @SerializedName("requirement8_5")
    String getRequirement8_5();
    @SerializedName("requirement8_6")
    String getRequirement8_6();
    @SerializedName("requirement8_7")
    String getRequirement8_7();
    @SerializedName("requirement8_8")
    String getRequirement8_8();
    @SerializedName("requirement8_9")
    String getRequirement8_9();
    @SerializedName("requirement8_10")
    String getRequirement8_10();
    @SerializedName("requirement9_1")
    String getRequirement9_1();
    @SerializedName("requirement9_2")
    String getRequirement9_2();
    @SerializedName("requirement9_3")
    String getRequirement9_3();
    @SerializedName("requirement9_4")
    String getRequirement9_4();
    @SerializedName("requirement9_5")
    String getRequirement9_5();
    @SerializedName("requirement9_6")
    String getRequirement9_6();
    @SerializedName("requirement9_7")
    String getRequirement9_7();
    @SerializedName("requirement9_8")
    String getRequirement9_8();
    @SerializedName("requirement9_9")
    String getRequirement9_9();
    @SerializedName("requirement9_10")
    String getRequirement9_10();
    @SerializedName("requirement10_1")
    String getRequirement10_1();
    @SerializedName("requirement10_2")
    String getRequirement10_2();
    @SerializedName("requirement10_3")
    String getRequirement10_3();
    @SerializedName("requirement10_4")
    String getRequirement10_4();
    @SerializedName("requirement10_5")
    String getRequirement10_5();
    @SerializedName("requirement10_6")
    String getRequirement10_6();
    @SerializedName("requirement10_7")
    String getRequirement10_7();
    @SerializedName("requirement10_8")
    String getRequirement10_8();
    @SerializedName("requirement10_9")
    String getRequirement10_9();
    @SerializedName("requirement10_10")
    String getRequirement10_10();
    @SerializedName("requirement11_1")
    String getRequirement11_1();
    @SerializedName("requirement11_2")
    String getRequirement11_2();
    @SerializedName("requirement11_3")
    String getRequirement11_3();
    @SerializedName("requirement11_4")
    String getRequirement11_4();
    @SerializedName("requirement11_5")
    String getRequirement11_5();
    @SerializedName("requirement11_6")
    String getRequirement11_6();
    @SerializedName("requirement11_7")
    String getRequirement11_7();
    @SerializedName("requirement11_8")
    String getRequirement11_8();
    @SerializedName("requirement11_9")
    String getRequirement11_9();
    @SerializedName("requirement11_10")
    String getRequirement11_10();
    @SerializedName("requirement12_1")
    String getRequirement12_1();
    @SerializedName("requirement12_2")
    String getRequirement12_2();
    @SerializedName("requirement12_3")
    String getRequirement12_3();
    @SerializedName("requirement12_4")
    String getRequirement12_4();
    @SerializedName("requirement12_5")
    String getRequirement12_5();
    @SerializedName("requirement12_6")
    String getRequirement12_6();
    @SerializedName("requirement12_7")
    String getRequirement12_7();
    @SerializedName("requirement12_8")
    String getRequirement12_8();
    @SerializedName("requirement12_9")
    String getRequirement12_9();
    @SerializedName("requirement12_10")
    String getRequirement12_10();
    @SerializedName("eligibility1")
    String getEligibility1();
    @SerializedName("eligibility2")
    String getEligibility2();
    @SerializedName("eligibility3")
    String getEligibility3();
    @SerializedName("eligibility4")
    String getEligibility4();
    @SerializedName("eligibility5")
    String getEligibility5();
    @SerializedName("eligibility6")
    String getEligibility6();
    @SerializedName("eligibility7")
    String getEligibility7();
    @SerializedName("eligibility8")
    String getEligibility8();
    @SerializedName("eligibility9")
    String getEligibility9();
    @SerializedName("eligibility10")
    String getEligibility10();
    @SerializedName("readingSAT")
    Integer getSATForReading();
    @SerializedName("readingSAT")
    void setSATForReading(Integer value);
    @SerializedName("writingSAT")
    Integer getSATForWriting();
    @SerializedName("writingSAT")
    void setSATForWriting(Integer value);
    @SerializedName("mathSAT")
    Integer getSATForMath();
    @SerializedName("mathSAT")
    void setSATForMath(Integer value);
}
