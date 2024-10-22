package Miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Input {
	private Date date;
    private double price;
    private String vendor;
    private String category;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	public Input(Date date, double price, String vendor, String category) throws ParseException {
        this.date = date;
        this.price = price;
        this.vendor = vendor;
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public String getVendor() {
        return vendor;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Input{" +
                "date=" + dateFormat.format(date) +
                ", price=" + price +
                ", vendor='" + vendor + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

