# gmd-core-demo 2.6.1
A modern demo for GMD widgets.

### Related Demo sites
- [2.2 Demo](https://gwtmaterialdesign.github.io/gwt-material-demo/#countUp)
- [Addins](https://gwtmaterialdesign.github.io/gmd-addins-demo/)
- [DataTable](https://gwtmaterialdesign.github.io/gmd-table-demo/)
- [AmCharts](https://gwtmaterialdesign.github.io/gmd-amcharts4-demo/)

### Running the demo app
Note: You must know Git and Maven before as prerequisites
1. Clone this demo project using git. `git clone https://github.com/GwtMaterialDesign/gmd-core-demo`
2. Open the project on your desired IDE (Intellij IDE or Eclipse)
3. Install the project using `mvn clean install`
4. Then run the project using `mvn gwt:codeserver`

Note: If you are using java 17,21 and IntelliJ Ultimate
you need to add VM Options : --add-opens java.base/java.lang=ALL-UNNAMED
and Dev Mode Parameters : -port 8891 -codeServerPort 9879
