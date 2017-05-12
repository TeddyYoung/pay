package com.aotu.mobile.vo;

import java.util.List;

public class BranchVo {

	
	private String currentLevel;
	private String currentLevelDisplay;
	private String subCount;
	private String nextLevel;
	private String nextLevelDisplay;
	private String nextLevelLeft;
	private List<SubBranchVo> subBranchs;
	
	public String getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}
	public String getCurrentLevelDisplay() {
		return currentLevelDisplay;
	}
	public void setCurrentLevelDisplay(String currentLevelDisplay) {
		this.currentLevelDisplay = currentLevelDisplay;
	}
	public String getSubCount() {
		return subCount;
	}
	public void setSubCount(String subCount) {
		this.subCount = subCount;
	}
	public String getNextLevel() {
		return nextLevel;
	}
	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}
	public String getNextLevelDisplay() {
		return nextLevelDisplay;
	}
	public void setNextLevelDisplay(String nextLevelDisplay) {
		this.nextLevelDisplay = nextLevelDisplay;
	}
	public String getNextLevelLeft() {
		return nextLevelLeft;
	}
	public void setNextLevelLeft(String nextLevelLeft) {
		this.nextLevelLeft = nextLevelLeft;
	}
	public List<SubBranchVo> getSubBranchs() {
		return subBranchs;
	}
	public void setSubBranchs(List<SubBranchVo> subBranchs) {
		this.subBranchs = subBranchs;
	}
	
	
}
