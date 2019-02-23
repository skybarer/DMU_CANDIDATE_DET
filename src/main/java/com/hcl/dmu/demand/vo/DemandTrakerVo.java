package com.hcl.dmu.demand.vo;

public class DemandTrakerVo {
	   
	   private int demandId;
       private String Sno;
       private String streamName;
       private String projectName;
       private String skill;
       private int count;
       private int fullfilled;
       private int gap;
       private DemandStreamVo demandStreamVo;
       
       public String getSno() {
              return Sno;
       }
       public void setSno(String sno) {
              Sno = sno;
       }
       public int getDemandId() {
              return demandId;
       }
       public void setDemandId(int demandId) {
              this.demandId = demandId;
       }
       public String getStreamName() {
              return streamName;
       }
       public void setStreamName(String streamName) {
              this.streamName = streamName;
       }
       public String getProjectName() {
              return projectName;
       }
       public void setProjectName(String projectName) {
              this.projectName = projectName;
       }
       public String getSkill() {
              return skill;
       }
       public void setSkill(String skill) {
              this.skill = skill;
       }
       public int getCount() {
              return count;
       }
       public void setCount(int count) {
              this.count = count;
       }
       public int getFullfilled() {
              return fullfilled;
       }
       public void setFullfilled(int fullfilled) {
              this.fullfilled = fullfilled;
       }
       public int getGap() {
              return gap;
       }
       public void setGap(int gap) {
              this.gap = gap;
       }
       public DemandStreamVo getDemandStreamVo() {
              return demandStreamVo;
       }
       public void setDemandStreamVo(DemandStreamVo demandStreamVo) {
              this.demandStreamVo = demandStreamVo;
       }
       @Override
       public String toString() {
              return "DemandTrakerVo [Sno=" + Sno + ", demandId=" + demandId + ", streamName=" + streamName + ", projectName="
                           + projectName + ", skill=" + skill + ", count=" + count + ", fullfilled=" + fullfilled + ", gap=" + gap
                           + ", demandStreamVo=" + demandStreamVo + "]";
       }

       
}

