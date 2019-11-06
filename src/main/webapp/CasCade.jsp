<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false"   %>

<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js">
    </script>
    <script type="application/javascript">
        $(function () {
            //发送Ajax请求获取所有省份
            $.ajax({
                url:"${pageContext.request.contextPath}/cascade/showProvinces",
                type:"GET",
                dataType:"json",
                success:function(provinces){
                    //遍历省份得到省份编号和省份名称
                    for (var i=0;i<provinces.length;i++) {
                        var  option=$("<option value="+provinces[i].code+">"+provinces[i].name+"</option>");
                        //追加
                        $("#province").append(option);
                    }
                    //发送Ajax请求吧选中的省份的code传入到后台 ，获取对应的城市
                    $.ajax({
                        url:"${pageContext.request.contextPath}/cascade/showCitys",
                        type:"GET",
                        data:"provincecode="+110000,
                        dataType:"json",
                        success:function(citys){
                            //每次添加新城市都需要清零
                            $("#city").empty();
                            for (var i=0;i<citys.length;i++){
                                var option=$("<option value="+citys[i].code+">"+citys[i].name+"</option>");
                                $("#city").append(option);
                            }

                            //发送Ajax请求吧选中的市的code传入到后台 获取该市对应的区和县
                            $.ajax({
                                url:"${pageContext.request.contextPath}/cascade/showAreas",
                                type:"GET",
                                data:"citycode="+110100,
                                dataType:"json",
                                success:function (areas) {
                                    //每次添加新区域都需要清零
                                    $("#area").empty();
                                    for (var i=0;i<areas.length;i++){
                                        var  option=  $("<option>"+areas[i].name+"</option>");
                                        $("#area").append(option);
                                    }
                                }
                            });
                        }
                    });
                }

            });
            //给第一个下拉框添加change事件
            $("#province").change(function (){
                //获取所选省份的编号
                var provincecode=$("#province option:selected").val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/cascade/showCitys",
                    type:"GET",
                    data:"provincecode="+provincecode,
                    dataType:"json",
                    success:function (citys) {
                        console.log(citys);
                        //每次添加新城市之前清零
                        $("#city").empty();
                        for (var i=0;i<citys.length;i++){
                            var option=$("<option value="+citys[i].code+">"+citys[i].name+"</option>");
                            $("#city").append(option);
                        }
                        //发送Ajax请求吧选中的市的code传入到后台 获取该市对应的区和县
                        $.ajax({
                            url:"${pageContext.request.contextPath}/cascade/showAreas",
                            type:"GET",
                            data:"citycode="+citys[0].code,
                            dataType:"json",
                            success:function (areas) {
                                $("#area").empty();
                                for (var i=0;i<areas.length;i++){
                                    var  option=  $("<option>"+areas[i].name+"</option>");
                                    $("#area").append(option);
                                }
                            }
                        });
                    }
                });
            });

            //城市下拉事件
            $("#city").change(function () {
                //获取用户选中市的code
                var  citycode=$("#city option:selected").val();
                //发送Ajax请求吧选中的市的code传入到后台 获取该市对应的区和县
                $.ajax({
                    url:"${pageContext.request.contextPath}/cascade/showAreas",
                    type:"GET",
                    data:"citycode="+citycode,
                    dataType:"json",
                    success:function (areas) {
                        $("#area").empty();
                        for (var i=0;i<areas.length;i++){
                            var  option=  $("<option>"+areas[i].name+"</option>");
                            $("#area").append(option);
                        }
                    }
                });
            });

        });

    </script>
</head>
<body>
<!--省-->
<select id="province">
</select>
<!--市-->
<select id="city">
</select>
<!--区县-->
<select id="area">
</select>
</body>
</html>
