/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
        Создать множество ноутбуков.
        Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
        Критерии фильтрации можно хранить в Map.
        Например: “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/
public class Notebook {
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getVideoMemory() {
        return videoMemory;
    }

    public void setVideoMemory(int videoMemory) {
        this.videoMemory = videoMemory;
    }

    int price;
    double rating;
    String company;
    String title;
    double screenDiagonal;
    int ram;
    int hardDiskCapacity;
    String operatingSystem;
    int videoMemory;



    public Notebook(int price, double rating, String company, String title, double screenDiagonal, int ram, int hardDiskCapacity, String operatingSystem, int videoMemory){
        this.price = price;
        this.rating = rating;
        this.company = company;
        this.title = title;
        this.screenDiagonal=screenDiagonal;
        this.ram = ram;
        this.hardDiskCapacity=hardDiskCapacity;
        this.operatingSystem=operatingSystem;
        this.videoMemory=videoMemory;
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer("Notebook{");
        sb.append("price = ").append(price);
        sb.append("| rating = ").append(rating);
        sb.append("| company = ").append(company);
        sb.append("| title = ").append(title);
        sb.append("| screenDiagonal = ").append(screenDiagonal);
        sb.append("| ram = ").append(ram);
        sb.append("| hardDiskCapacity = ").append(hardDiskCapacity);
        sb.append("| operatingSystem = ").append(operatingSystem);
        sb.append("| videoMemory = ").append(videoMemory);
        sb.append("}");
        return sb.toString();
    }


}
