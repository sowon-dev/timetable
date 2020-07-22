package timetable;

import java.sql.Date;

public class Tablebean {
	private Date mon_dd;
	private String weekday;
	private String subam;
	private String subpm;
	
	public Date getMon_dd() {
		return mon_dd;
	}
	public void setMon_dd(Date mon_dd) {
		this.mon_dd = mon_dd;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getSubam() {
		return subam;
	}
	public void setSubam(String subam) {
		this.subam = subam;
	}
	public String getSubpm() {
		return subpm;
	}
	public void setSubpm(String subpm) {
		this.subpm = subpm;
	}
	@Override
	public String toString() {
		return "Tablebean [mon_dd=" + mon_dd + ", weekday=" + weekday + ", subam=" + subam + ", subpm=" + subpm + "]";
	}
	
	
}
