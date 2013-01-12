<%@page import="com.pub.util.monitor.WindowsInfoUtil,com.pub.util.monitor.DiskInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="pageContent sortDrag" selector="h1" layoutH="42">

            <%
            long[] mem = WindowsInfoUtil.getMemery();
            long[] cpu = WindowsInfoUtil.getCpuRatioForWindows();
            List<DiskInfo> list = WindowsInfoUtil.getDisk();
            String dataStrUse="";
            String dataStrUnUse="";
            String lableStr="";
            for(DiskInfo d:list) {
            	dataStrUse+=d.getPercent()+",";
            	dataStrUnUse+=(100-d.getPercent())+",";
            	lableStr+="[\""+d.getName()+"\"]"+",";
            }
            dataStrUse = dataStrUse.substring(0,dataStrUse.length()-1);
            dataStrUnUse = dataStrUnUse.substring(0,dataStrUnUse.length()-1);
            lableStr = lableStr.substring(0,lableStr.length()-1);
            
            
            
            %>
                <script type="text/javascript" charset="utf-8">
                /* Title settings */        
                title = "内存使用率（<%=mem[0]+mem[1]%>M）";
                titleXpos = 130;
                titleYpos = 35;
                
                /* Pie Data */
                pieRadius = 80;
                pieXpos = 100;
                pieYpos = 130;
                pieData = [<%=mem[0]%>, <%=mem[1]%>];
                pieLegend = [
                "%%.%% – 已用<%=mem[0]%>M", 
                "%%.%% – 空闲<%=mem[1]%>M"];
                
                pieLegendPos = "south";
                
                $(function () {
                    var r = Raphael("chartHolderMem");
                     
                    r.text(titleXpos, titleYpos, title).attr({"font-size": 20});
                    
                    var pie = r.piechart(pieXpos, pieYpos, pieRadius, pieData, {legend: pieLegend, legendpos: pieLegendPos});
                    pie.hover(function () {
                        this.sector.stop();
                        this.sector.scale(1.1, 1.1, this.cx, this.cy);
                        if (this.label) {
                            this.label[0].stop();
                            this.label[0].attr({ r: 7.5 });
                            this.label[1].attr({"font-weight": 800});
                        }
                    }, function () {
                        this.sector.animate({ transform: 's1 1 ' + this.cx + ' ' + this.cy }, 500, "bounce");
                        if (this.label) {
                            this.label[0].animate({ r: 5 }, 500, "bounce");
                            this.label[1].attr({"font-weight": 400});
                        }
                    });
                    
                });
                </script>
                <span id="chartHolderMem"></span>
            <script type="text/javascript" charset="utf-8">
                /* Title settings */        
                title = "CPU使用率";
                titleXpos = 130;
                titleYpos = 35;
                
                /* Pie Data */
                pieRadius = 80;
                pieXpos = 100;
                pieYpos = 130;
                pieData = [<%=cpu[0]%>, <%=cpu[1]%>];
                pieLegend = [
                "%%.%% – 使用中", 
                "%%.%% – 空闲中"];
                
                pieLegendPos = "south";
                
                $(function () {
                    var r = Raphael("chartHolderCpu");
                     
                    r.text(titleXpos, titleYpos, title).attr({"font-size": 20});
                    
                    var pie = r.piechart(pieXpos, pieYpos, pieRadius, pieData, {legend: pieLegend, legendpos: pieLegendPos});
                    pie.hover(function () {
                        this.sector.stop();
                        this.sector.scale(1.1, 1.1, this.cx, this.cy);
                        if (this.label) {
                            this.label[0].stop();
                            this.label[0].attr({ r: 7.5 });
                            this.label[1].attr({"font-weight": 800});
                        }
                    }, function () {
                        this.sector.animate({ transform: 's1 1 ' + this.cx + ' ' + this.cy }, 500, "bounce");
                        if (this.label) {
                            this.label[0].animate({ r: 5 }, 500, "bounce");
                            this.label[1].attr({"font-weight": 400});
                        }
                    });
                    
                });
                </script>
                
                <span id="chartHolderCpu"></span>
	<div class="panel collapse" minH="100" defH="360">
        <h1>硬盘资源情况</h1>
        <div>
            <script type="text/javascript">
		    var options = {
		        stacked: false,
		        gutter:20,
		        axis: "0 0 1 1", // Where to put the labels (trbl)
		        axisystep: 10 // How many x interval labels to render (axisystep does the same for the y axis)
		    };
		    
		    $(function() {
		        // Creates canvas
		        var r = Raphael("chartHolder");
		        var data = [[<%=dataStrUse%>],[<%=dataStrUnUse%>]]
		        		        
		        // stacked: true
		        options.stacked=true;
		        
		        var chart2 = r.barchart(80, 10, 320, 220, data, options).hoverColumn(function() {
		            var y = [], res = [];
		            for (var i = this.bars.length; i--;) {
		                y.push(this.bars[i].y);
		                res.push(this.bars[i].value || "0");
		            }
		            this.flag = r.popup(this.bars[0].x, Math.min.apply(Math, y), res.join(", ")).insertBefore(this);
		        }, function() {
		            this.flag.animate({opacity: 0}, 500, ">", function () {this.remove();});
		        });
		        chart2.label([<%=lableStr%>],true);
		    });
		</script>
		
		<div id="chartHolder"></div>
        </div>
    </div>
</div>
