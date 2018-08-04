package dao;

/**
 * Created by zoujian on 2018/7/29.
 */
public class SystemDb {
    private String allBasicInfo;
    private String allSubject;
    private String plusP;
    private String negativeP;
    private String plusS;
    private String negativeS;
    private String plusQ;
    private String negativeQ;
    private String plusT;
    private String negativeT;
    private String basicInfo;
    private String subject;
    private String type;
    private String region;
    private String basicInfoField;
    private String subjectField;
    private String typeRange;
    private String regionRange;
    private int indexP;
    private int indexS;
    private int indexQ;
    private int indexT;
    private int indexPkuohao;
    private int indexSkuohao;
    private int indexQkuohao;
    private int indexTkuohao;
    private String sidVal;
    private String nameVal;
    private String ageVal;
    private String genderVal;
    private String schoolVal;
    private String chineseVal;
    private String mathVal;
    private String englishVal;
    private String physicsVal;
    private String historyVal;
    private String geographyVal;
    private String artVal;
    private String totalVal;
    private String regionVal;
    private String typeVal;

    public String getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBasicInfoField() {
        return basicInfoField;
    }

    public void setBasicInfoField(String basicInfoField) {
        this.basicInfoField = basicInfoField;
    }

    public String getSubjectField() {
        return subjectField;
    }

    public void setSubjectField(String subjectField) {
        this.subjectField = subjectField;
    }

    public String getTypeRange() {
        return typeRange;
    }

    public void setTypeRange(String typeRange) {
        this.typeRange = typeRange;
    }

    public String getRegionRange() {
        return regionRange;
    }

    public void setRegionRange(String regionRange) {
        this.regionRange = regionRange;
    }

    public String getSidVal() {
        return sidVal;
    }

    public void setSidVal(String sidVal) {
        this.sidVal = sidVal;
    }

    public String getNameVal() {
        return nameVal;
    }

    public void setNameVal(String nameVal) {
        this.nameVal = nameVal;
    }

    public String getAgeVal() {
        return ageVal;
    }

    public void setAgeVal(String ageVal) {
        this.ageVal = ageVal;
    }

    public String getGenderVal() {
        return genderVal;
    }

    public void setGenderVal(String genderVal) {
        this.genderVal = genderVal;
    }

    public String getSchoolVal() {
        return schoolVal;
    }

    public void setSchoolVal(String schoolVal) {
        this.schoolVal = schoolVal;
    }

    public String getChineseVal() {
        return chineseVal;
    }

    public void setChineseVal(String chineseVal) {
        this.chineseVal = chineseVal;
    }

    public String getMathVal() {
        return mathVal;
    }

    public void setMathVal(String mathVal) {
        this.mathVal = mathVal;
    }

    public String getEnglishVal() {
        return englishVal;
    }

    public void setEnglishVal(String englishVal) {
        this.englishVal = englishVal;
    }

    public String getPhysicsVal() {
        return physicsVal;
    }

    public void setPhysicsVal(String physicsVal) {
        this.physicsVal = physicsVal;
    }

    public String getHistoryVal() {
        return historyVal;
    }

    public void setHistoryVal(String historyVal) {
        this.historyVal = historyVal;
    }

    public String getGeographyVal() {
        return geographyVal;
    }

    public void setGeographyVal(String geographyVal) {
        this.geographyVal = geographyVal;
    }

    public String getArtVal() {
        return artVal;
    }

    public void setArtVal(String artVal) {
        this.artVal = artVal;
    }

    public String getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(String totalVal) {
        this.totalVal = totalVal;
    }

    public String getRegionVal() {
        return regionVal;
    }

    public void setRegionVal(String regionVal) {
        this.regionVal = regionVal;
    }

    public String getTypeVal() {
        return typeVal;
    }

    public void setTypeVal(String typeVal) {
        this.typeVal = typeVal;
    }

    public void showSpecificField(String sentence){
        allBasicInfo="考号，姓名，年龄";
        allSubject="语文，数学，英语，历史，地理，物理，艺术";
        indexP=sentence.indexOf('P');
        indexS=sentence.indexOf('S');
        indexQ=sentence.indexOf('Q');
        indexT=sentence.indexOf('T');
        indexPkuohao=sentence.indexOf(')',indexP);
        indexSkuohao=sentence.indexOf(')',indexS);
        indexQkuohao=sentence.indexOf(')',indexQ);
        indexTkuohao=sentence.indexOf(')',indexT);

        if (sentence.charAt(0)=='P'){
            plusP=sentence.substring(indexP+2,indexPkuohao);
            negativeP="";
        }else
        {
            negativeP=sentence.substring(indexP+2,indexPkuohao);
            plusP="";
        }
        if (sentence.charAt(indexS-1)=='+'){
            plusS=sentence.substring(indexS+2,indexSkuohao);
            negativeS="";
        }else
        {
            negativeS=sentence.substring(indexS+2,indexSkuohao);
            plusS="";
        }
        if (sentence.charAt(indexQ-1)=='+'){
            plusQ=sentence.substring(indexQ+2,indexQkuohao);
            negativeQ="";
        }else
        {
            negativeQ=sentence.substring(indexQ+2,indexQkuohao);
            plusQ="";
        }
        if (sentence.charAt(indexT-1)=='+'){
            plusT=sentence.substring(indexT+2,indexTkuohao);
            negativeT="";
        }else
        {
            negativeT=sentence.substring(indexT+2,indexTkuohao);
            plusT="";
        }



        if (plusS!=""){
            basicInfo=plusS;
        }else{
            String array[]=negativeS.split("，");
            basicInfo=allBasicInfo;
            for (int i=0;i<array.length;i++){
                basicInfo=basicInfo.replace(array[i],"");
            }
            do {
                basicInfo=basicInfo.replace("，，","，");
            }while (basicInfo.indexOf("，，")!=-1);
            if (basicInfo.charAt(0)=='，'){
                basicInfo=basicInfo.substring(1,basicInfo.length());
            }
            if (basicInfo.charAt(basicInfo.length()-1)=='，'){
                basicInfo=basicInfo.substring(0,basicInfo.length()-1);
            }
        }

        if (plusT!=""){
            subject=plusT;
        }else{
            String array[]=negativeT.split("，");
            subject=allSubject;
            for (int i=0;i<array.length;i++){
                subject=subject.replace(array[i],"");
            }
            do {
                subject=subject.replace("，，","，");
            }while (subject.indexOf("，，")!=-1);
            if (subject.charAt(0)=='，'){
                subject=subject.substring(1,subject.length());
            }
            if (subject.charAt(subject.length()-1)=='，'){
                subject=subject.substring(0,subject.length()-1);
            }
        }

        if (plusP!=""){
            regionRange=plusP;
            regionRange=regionRange.replace("，","','");
            StringBuilder sb=new StringBuilder(regionRange);
            sb.insert(0,"'");
            sb.insert(sb.length(),"'");
            regionRange=sb.toString();
            regionRange="in ("+regionRange+")";
        }else {
            regionRange=negativeP;
            regionRange=regionRange.replace("，","','");
            StringBuilder sb=new StringBuilder(regionRange);
            sb.insert(0,"'");
            sb.insert(sb.length(),"'");
            regionRange=sb.toString();
            regionRange="not in ("+regionRange+")";
        }

        if (plusQ!=""){
            typeRange=plusQ;
            typeRange=typeRange.replace("，","','");
            StringBuilder sb=new StringBuilder(typeRange);
            sb.insert(0,"'");
            sb.insert(sb.length(),"'");
            typeRange=sb.toString();
            typeRange="in ("+typeRange+")";
        }else {
            typeRange=negativeQ;
            typeRange=typeRange.replace("，","','");
            StringBuilder sb=new StringBuilder(typeRange);
            sb.insert(0,"'");
            sb.insert(sb.length(),"'");
            typeRange=sb.toString();
            typeRange="not in ("+typeRange+")";
        }

        basicInfoField=basicInfo;
        basicInfoField=basicInfoField.replace("年龄","age");
        basicInfoField=basicInfoField.replace("姓名","name");
        basicInfoField=basicInfoField.replace("考号","sid");
        basicInfoField=basicInfoField.replace("，",",");

        subjectField=subject;
        subjectField=subjectField.replace("语文","chinese");
        subjectField=subjectField.replace("数学","math");
        subjectField=subjectField.replace("英语","english");
        subjectField=subjectField.replace("物理","physics");
        subjectField=subjectField.replace("历史","history");
        subjectField=subjectField.replace("地理","geography");
        subjectField=subjectField.replace("艺术","chinese");
        subjectField=subjectField.replace("，",",");

        setBasicInfo(basicInfo);
        setSubject(subject);
        setType("考生类型");
        setRegion("地区");
        setBasicInfoField(basicInfoField);
        setSubjectField(subjectField);
        setTypeRange(typeRange);
        setRegionRange(regionRange);

    }

}
