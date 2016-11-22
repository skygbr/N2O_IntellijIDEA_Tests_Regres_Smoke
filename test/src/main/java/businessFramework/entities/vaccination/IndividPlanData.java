package businessFramework.entities.vaccination;


public class IndividPlanData implements Cloneable
{
    private String patient;
    private String calendar;
    private String clinic;
    private String resourse;
    private String vaccine;
    private String phase;
    private String series;
    private String birthDate;
    private String infection;
    private String groupOfRisk1;
    private String groupOfRisk2;
    private String vacDepartment;
    private String schema;
    private String probe;
    private String probePhase;
    private String probeInfection;

    public String getPatient()
    {
        return patient;
    }

    public void setPatient(String patient)
    {
        this.patient = patient;
    }

    public String getCalendar()
    {
        return calendar;
    }

    public void setCalendar(String calendar)
    {
        this.calendar = calendar;
    }

    public String getClinic()
    {
        return clinic;
    }

    public void setClinic(String clinic)
    {
        this.clinic = clinic;
    }

    public String getResourse()
    {
        return resourse;
    }

    public void setResourse(String resourse)
    {
        this.resourse = resourse;
    }

    public String getVaccine()
    {
        return vaccine;
    }

    public String getProbe()
    {
        return probe;
    }

    public void setVaccine(String vaccine)
    {
        this.vaccine = vaccine;
    }

    public void setProbe(String probe)
    {
        this.probe = probe;
    }

    public String getPhase()
    {
        return phase;
    }

    public String getProbePhase()
    {
        return probePhase;
    }

    public void setPhase(String phase)
    {
        this.phase = phase;
    }

    public void setProbePhase(String probePhase)
    {
        this.probePhase = probePhase;
    }

    public String getSeries()
    {
        return series;
    }

    public void setSeries(String series)
    {
        this.series = series;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getInfection()
    {
        return infection;
    }

    public String getProbeInfection()
    {
        return probeInfection;
    }

    public void setInfection(String infection)
    {
        this.infection = infection;
    }

    public void setProbeInfection(String probeInfection)
    {
        this.probeInfection = probeInfection;
    }

    public String getGroupOfRisk1()
    {
        return groupOfRisk1;
    }

    public String getGroupOfRisk2()
    {
        return groupOfRisk2;
    }

    public void setGroupOfRisk1(String groupOfRisk1)
    {
        this.groupOfRisk1 = groupOfRisk1;
    }

    public void setGroupOfRisk2(String groupOfRisk2)
    {
        this.groupOfRisk2 = groupOfRisk2;
    }

    public String getVacDepartment()
    {
        return vacDepartment;
    }

    public void setVacDepartment(String vacDepartment)
    {
        this.vacDepartment = vacDepartment;
    }


   public String getSchema()
   {
       return schema;
   }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }





}

