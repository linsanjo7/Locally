package lynapp.labs.locally;

public class CategoryInfo {
    
    public String categ_url;
    public String catg_name;
    
    public CategoryInfo(){}
    
    public CategoryInfo(String categ_url,String categ_name){
        this.categ_url = categ_url;
        this.catg_name = categ_name;
    }
    
    public String getCateg_url() {
        return categ_url;
    }
    
    public String getCatg_name() {
        return catg_name;
    }
    
    public void setCateg_url(String categ_url) {
        this.categ_url = categ_url;
    }
    
    public void setCatg_name(String catg_name) {
        this.catg_name = catg_name;
    }
}
