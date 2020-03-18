package lynapp.labs.locally;

public class WorkInfo {
    
    public String category;
    public String empName;
    public String imgURL;
    public int rating;
    public String description;
    public long number;
    
    public WorkInfo(){}
    
    public WorkInfo(String category,String empName,String imgURL,int rating,String description,long number){
        
        this.category = category;
        this.empName = empName;
        this.imgURL =  imgURL;
        this.rating = rating;
        this.description = description;
        this.number = number;
    
    }
    
    public int getRating() {
        return rating;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public String getImgURL() {
        return imgURL;
    }
    
    public long getNumber() {
        return number;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void setNumber(long number) {
        this.number = number;
    }
}
