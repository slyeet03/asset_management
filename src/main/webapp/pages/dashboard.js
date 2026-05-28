function displaydetails() {
  var url = "getDetails.htm";
  var branch = $("#branch").val();
  var categoryid = $("#categoryid").val();
  var subcategoryid = $("#subcategoryid").val();
  var assetid = $("#assetid").val();

  var shrnumb = $("#shrnumb").val();
  var memtype = $("#memtype").val();
  var shrclass = $("#shrclass").val();

  $.ajax({
    url: url,
    type: "POST",
    data: {
      branch: branch,
      categoryid: categoryid,
      subcategoryid: subcategoryid,
      assetid: assetid,
      _csrf: $(".csrf").val(),
    },
    dataType: "json",
    async: false,
    error: function (xhr, status, error) {
      console.log("Error: " + error);
    },
    success: function (data) {
      if (data.SaveStatus == "1") {
        $("#totalAssets").html(data.totalAssets);
        $("#totalPOAmount").html(data.totalPOAmount);
        $("#totalBookValue").html(data.totalBookValue);
        $("#totalDepreciation").html(data.totalDepreciation);
      }
    },
  });

  $.ajax({
    url: url,
    type: "POST",
    data: {
      shrnumb: shrnumb,
      _csrf: $(".csrf").val(),
      memtype: memtype,
      _csrf: $(".csrf").val(),
      shrclass: shrclass,
      _csrf: $(".csrf").val(),
    },
    dataType: "json",
    async: false,
    error: function (xhr, status, error) {
      var err = xhr.responseText;
      if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
        window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
      }
    },
    beforeSend: function () {},
    success: function (data) {
      debugger;
      var response = data.details11;
      if (response.length > 0) {
        for (var i = 0; i < response.length; i++) {
          var data1 = response[i];
          $('input[name="nos"]').val(data1[1]);
          $('input[name="amt"]').val(data1[2]);
          $('input[name="noc"]').val(data1[3]);
        }
      } else {
        $('input[name="nos"]').val("0");
        $('input[name="noc"]').val("0");
        $('input[name="amt"]').val("0");
      }
    },
  });
}

$(function () {
  $("#gobtn").on("click", function () {
    displaydetails();
    var subREGL = $("#tableWithSearch").DataTable();
    subREGL.clear().draw();
    var setting = {
      destroy: true,
      scrollY: "100px",
      scrollX: false,
      scrollCollapse: true,
      paging: false,
      ordering: false,
      searching: false,
      info: false,
    };
    $("#tableWithSearch").DataTable(setting);
    $(".dataTables_scrollBody").scrollbar();
    $(".dataTables_scrollBody").css("height", "150px");
    $("#tableWithSearch").css("width", "100%");
    $(".scrollable").scrollbar();
    //fetch detail
    var shareno = $('input[name="shrnumb"]').val();
    var membertype = $('select[name="memtype"]').val();
    var shareclass = $('select[name="shrclass"]').val();
    var fname = $('input[name="fname"]').val();
    var mname = $('input[name="mname"]').val();
    var lname = $('input[name="lname"]').val();
    var firmname = $('input[name="firmname"]').val();
    var cif = $('input[name="cif"]').val();
    var pan = $('input[name="panno"]').val();
    var aadhar = $('input[name="aadhar"]').val();

    if (
      shareno != "" ||
      membertype != "" ||
      shareclass != "" ||
      fname != "" ||
      mname != "" ||
      lname != "" ||
      firmname != "" ||
      cif != "" ||
      pan != "" ||
      aadhar != ""
    ) {
      $("#sharediv").css("display", "block");
      var hrefaction = "SearchDashboardFolio.json";
      $.ajax({
        type: "POST",
        url: hrefaction,
        data: {
          memtype: membertype,
          shrclass: shareclass,
          shrnumb: shareno,
          fname: fname,
          mname: mname,
          lname: lname,
          firmname: firmname,
          cif: cif,
          pan: pan,
          aadhar: aadhar,
          _csrf: $(".csrf").val(),
        },
        dataType: "json",
        async: true,
        error: function (xhr, err, op) {
          var responseText = xhr.responseText;
          if (responseText.toLowerCase().indexOf("session_timed_out") >= 0) {
            window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
          }
          return false;
        },
        beforeSend: function () {
          $.blockUI();
        },
        success: function (data) {
          var response = data.details;
          for (var i = 0; i < response.length; i++) {
            var data1 = response[i];
            var status;
            if (data1[7] != null && data1[7] == "0") {
              status = "CLOSE";
            } else {
              status = "OPEN";
            }
            var wp =
              status +
              '<input type="hidden" name="memtypetd"  value="' +
              data1[2] +
              '"/><input type="hidden" name="shrclasstd"  value="' +
              data1[3] +
              '"/>';
            $("#tableWithSearch")
              .DataTable()
              .row.add([data1[4], data1[5], data1[0], data1[1], wp])
              .draw(false);
            $("#tableWithSearch")
              .children("tbody")
              .each(function () {
                $(this)
                  .children("tr")
                  .each(function () {
                    $(this)
                      .children("td")
                      .each(function () {
                        $(this).css("cursor", "pointer");
                      });
                  });
              });
            /*var table = $('#tableWithSearch').DataTable();
		    		    $('#tableWithSearch tbody').on('click', 'tr', function () {
		    		    	 var data = table.row( this ).data();
		    		    	 var memtypesel = data[4].split('value="')[1].split('"/>')[0];
		    		    	 var shrclasssel = data[4].split('/><')[1].split('value="')[1].split('"/>')[0];
			    			 display(data[2],memtypesel,shrclasssel,data[1]);
			    		});*/
          }
        },
        complete: function () {
          $.unblockUI();
        },
      });
    } else {
      $("#errorModalHead").html(
        '<h4 class="no-margin p-b-10 text-danger">Alert!!!</h2>',
      );
      $("#errorModalBody").html(
        '<h5 class="no-margin p-b-10 text-danger">Please Enter any one detail for Search</h4>',
      );
      $(".errorModal").modal("show");
    }
  });

  $("#tableWithSearch tbody").on("click", "tr", function () {
    var shaclassdesc = $(this).find("td:eq(1)").html();
    var shrnumb = $(this).find("td:eq(2)").html();
    var hiddenval = $(this).find("td:eq(4)").html();
    var memtypesel = hiddenval.split('value="')[1].split('">')[0];
    var shrclasssel = hiddenval
      .split("><")[1]
      .split('value="')[1]
      .split('">')[0];

    $("#picMemType").val(memtypesel);
    $("#picShrClass").val(shrclasssel);
    $("#picShrNumb").val(shrnumb);

    display(shrnumb, memtypesel, shrclasssel, shaclassdesc);
  });
});

function viewImgSign() {
  $.ajax({
    type: "GET",
    url: "getphotoNSign.json",
    data: {
      memtype: $("#picMemType").val(),
      shrclass: $("#picShrClass").val(),
      shrnumb: $("#picShrNumb").val(),
      _csrf: $(".csrf").val(),
    },
    dataType: "json",
    async: true,
    error: function (xhr, err, op) {
      var responseText = xhr.responseText;
      if (responseText.toLowerCase().indexOf("session_timed_out") >= 0) {
        window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
      }
      return false;
    },
    beforeSend: function () {
      $.blockUI();
    },
    success: function (data) {
      var response = data.details;
      var photo = response.split("~")[0];
      var sign = response.split("~")[1];
      if ((photo && photo != "") || (sign && sign != "")) {
        $("#viewPhoto").attr("src", photo);
        $("#viewSign").attr("src", sign);
        $("#photoNSignModel").modal("show");
      } else {
        $("#modalheader").html(
          '<p class="text-danger semi-bold text-uppercase fs-16">Alert!!</p>',
        );
        $("#modalbody").html("Photo & Sign are not uploaded. ");
        $("#modalfooter").css("display", "none");
        $("#generalmodal").modal("show");
      }
    },
    complete: function () {
      $.unblockUI();
    },
  });
}

function display(shrnumb, memtype, shrclass, shrclassdesc) {
  var nos = $("#nos").val();
  var noc = $("#noc").val();
  var amt = $("#amt").val();
  var settings1 = {
    destroy: true,
    scrollY: "100px",
    scrollX: false,
    scrollCollapse: true,
    paging: false,
    ordering: false,
    searching: false,
    info: false,
  };
  var jointable, certitable;
  if (!$.fn.DataTable.isDataTable("#tableWithSearchJoin")) {
    jointable = $("#tableWithSearchJoin").DataTable(settings1);
    $("#tableWithSearchJoin_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .scrollbar();
    $("#tableWithSearchJoin_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .css("height", "90px");
    $(".scrollbar-wrapper").scrollbar();
  } else {
    jointable = $("#tableWithSearchJoin").DataTable();
    jointable.destroy();
    jointable = $("#tableWithSearchJoin").DataTable(settings1);
    $("#tableWithSearchJoin_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .scrollbar();
    $("#tableWithSearchJoin_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .css("height", "90px");
    $(".scrollbar-wrapper").scrollbar();
  }
  if (!$.fn.DataTable.isDataTable("#tableWithSearchCert")) {
    certitable = $("#tableWithSearchCert").DataTable(settings1);
    $("#tableWithSearchCert_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .scrollbar();
    $("#tableWithSearchCert_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .css("height", "100px");
    $(".scrollbar-wrapper").scrollbar();
  } else {
    certitable = $("#tableWithSearchCert").DataTable();
    certitable.destroy();
    certitable = $("#tableWithSearchCert").DataTable(settings1);
    $("#tableWithSearchCert_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .scrollbar();
    $("#tableWithSearchCert_wrapper")
      .children(".dataTables_scroll")
      .children(".dataTables_scrollBody")
      .css("height", "100px");
    $(".scrollbar-wrapper").scrollbar();
  }

  var url = "MemberInformation.json";
  $.ajax({
    url: url,
    type: "POST",
    dataType: "json",
    async: true,
    data: {
      memtype: memtype,
      shrclass: shrclass,
      shrnumb: shrnumb,
    },
    error: function (xhr, status, error) {
      var err = xhr.responseText;
      if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
        window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
      }
    },
    beforeSend: function () {
      $.blockUI();
    },
    success: function (response) {
      var error = parseInt(response.SaveStatus);
      if (!isNaN(error)) {
        if (error == 0) {
          $.unblockUI();
          jointable.clear().draw();
          certitable.clear().draw();
          var sharedetail = response.Sharedetails;
          var cifdetail = response.CIFdetails;
          var CertidetailObj = response.CertidetailObjs;

          $(".memtype").html(
            populateParamastLDesc(sharedetail.memtype, "MEMT"),
          );
          $(".shrclass").html(shrclassdesc); //sharedetail.shrclass
          $(".shrnumb").html(sharedetail.shrnumb);
          $(".memname").html(sharedetail.memname);
          $(".acctno").html(sharedetail.accnumb);
          //$('.noofshare').html(sharedetail.shares);
          //$('.noofcerti').html(sharedetail.certies);
          //$('.shramt').html(sharedetail.shramt);
          $(".noofshare").html(nos);
          $(".noofcerti").html(noc);
          $(".shramt").html(amt);

          $(".cif").html(sharedetail.cif);
          if (cifdetail != null) {
            $(".pan").html(cifdetail.pan);
            $(".aadhar").html(cifdetail.aadhar);
            var state = populateParamastLDesc(cifdetail.pstate, "STATE");
            if (!state) {
              state = "";
            }
            var pin = cifdetail.ppincode;
            if (!pin) {
              pin = "";
            }

            if (state != "") {
              $(".address").html(
                cifdetail.padd1 +
                  "," +
                  cifdetail.pcity +
                  "," +
                  state +
                  "-" +
                  pin,
              );
            } else {
              $(".address").html(
                cifdetail.padd1 +
                  "," +
                  cifdetail.pcity +
                  "," +
                  state +
                  "" +
                  pin,
              );
            }
          }
          if (sharedetail.certies != null && sharedetail.certies == "0") {
            $(".status").html("CLOSE");
          } else {
            $(".status").html("OPEN");
          }
          if (
            sharedetail.opendate != "" &&
            sharedetail.opendate != undefined &&
            sharedetail.opendate != null &&
            sharedetail.opendate != ""
          ) {
            $(".opendt").html(convertdate(sharedetail.opendate));
          }
          $(".statusdt").html("");
          if (
            sharedetail.appldate != "" &&
            sharedetail.appldate != undefined &&
            sharedetail.appldate != null &&
            sharedetail.appldate != ""
          ) {
            $(".appldt").html(convertdate(sharedetail.appldate));
          }
          if (
            sharedetail.sancdate != "" &&
            sharedetail.sancdate != undefined &&
            sharedetail.sancdate != null &&
            sharedetail.sancdate != ""
          ) {
            $(".sancdt").html(convertdate(sharedetail.sancdate));
          }

          for (var i = 0; i < response.Jointdetails.length; i++) {
            var joinmast = response.Jointdetails[i];
            var nomino, nomirelation, nomidate;
            if (
              joinmast.nominumb != "" &&
              joinmast.nominumb != null &&
              joinmast.nominumb != undefined &&
              joinmast.nominumb != ""
            ) {
              nomino = joinmast.nominumb;
            } else {
              nomino = "0";
            }
            if (
              joinmast.nomidateregi != "" &&
              joinmast.nomidateregi != null &&
              joinmast.nomidateregi != undefined &&
              joinmast.nomidateregi != ""
            ) {
              nomidate = convertdate(joinmast.nomidateregi);
            } else {
              nomidate = "-";
            }
            if (
              joinmast.nomirela != "" &&
              joinmast.nomirela != null &&
              joinmast.nomirela != undefined &&
              joinmast.nomirela != ""
            ) {
              nomirelation = populateParamastLDesc(joinmast.nomirela, "RELA");
            } else {
              nomirelation = "-";
            }
            var dt = "";
            if (joinmast.joindate) {
              dt = convertdate(joinmast.joindate);
            }
            var yesno = populateParamastLDesc(joinmast.votingright, "YESNO");
            if (!yesno) {
              yesno = "";
            }
            jointable.row
              .add([
                joinmast.joinnumb,
                joinmast.joinname,
                populateParamastLDesc(joinmast.capacity, "CAPACITY"),
                joinmast.joinorder,
                dt,
                yesno,
                nomino,
                nomidate,
                nomirelation,
              ])
              .draw(false);
          }
          for (var i = 0; i < response.Certidetails.length; i++) {
            var certmast = response.Certidetails[i];
            // certitable.row.add([certmast.certnumb, certmast.shares,certmast.shramt, certmast.dist1,'', certmast.dist2,'', certmast.trantype,certmast.certtrntyp,'', convertdate(certmast.appldate),'', convertdate(certmast.sancdate),'', convertdate(CertidetailObj[i][0]), '']).draw(false);
            certitable.row
              .add([
                certmast[1],
                certmast[5],
                certmast[6],
                certmast[8],
                "",
                certmast[9],
                "",
                certmast[3],
                certmast[4],
                "",
                convertdate(certmast[7]),
                "",
                certmast[0],
                "",
                convertdate(certmast[2]),
                "",
                certmast[10],
              ])
              .draw(false);
          }

          $(".dataTables_scrollFoot > .dataTables_scrollFootInner").css(
            "padding-right",
            "",
          );
          $(".dataTables_scrollFoot > .dataTables_scrollFootInner").width(
            "100%",
          );
          $("#tableWithSearchJoin").width("100%");
          $("#tableWithSearchJoin tbody")
            .children("tr")
            .each(function () {
              $(this).children("td").css("text-align", "center");
              $(this).children("td").addClass("no-padding");
              //$(this).children('td').css("width", '50px');
            });
          $("#tableWithSearchCert").width("100%");
          $("#tableWithSearchCert tbody")
            .children("tr")
            .each(function () {
              $(this).children("td").css("text-align", "center");
              $(this).children("td").addClass("no-padding");
              //$(this).children('td').css("width", '50px');
            });
          $(
            ".dataTables_scrollHeadInner,.dataTables_scrollHeadInner table",
          ).each(function () {
            try {
              $(this).width("100%");
            } catch (e) {}
          });
          $(
            ".dataTables_scrollFootInner,.dataTables_scrollFootInner table",
          ).each(function () {
            try {
              $(this).width("100%");
            } catch (e) {}
          });

          $("#myModal").modal("show");
        } else {
          $("#errorModalHead").html(
            '<h4 class="no-margin p-b-10 text-danger">Error!!!</h2>',
          );
          $("#errorModalBody").html(
            '<h5 class="no-margin p-b-10 text-danger">' +
              response.errorMsg +
              "</h4>",
          );
          $(".errorModal").modal("show");
        }
      }
    },
    complete: function () {
      $.unblockUI();
    },
  });
}

function populateParamastLDesc(pcode, ptype) {
  var result;
  $.ajax({
    url: "getParamastDesc.json",
    type: "POST",
    data: {
      Pcode: pcode,
      Ptype: ptype,
      _csrf: $(".csrf").val(),
    },
    dataType: "json",
    async: false,
    error: function (xhr, status, error) {
      var err = xhr.responseText;
      //alert(err);
      if (err.toLowerCase().indexOf("session_timed_out") >= 0) {
        window.location = "ProcessLogin.htm?statusCheck=SessionExpired";
      }
    },
    beforeSend: function () {},
    success: function (response) {
      var data = response.details;
      result = data.ldesc;
    },
  });
  return result;
}

function convertdate(val) {
  today = new Date(val);
  var dd = today.getDate();
  var mm = today.getMonth() + 1; //January is 0!
  var yyyy = today.getFullYear();
  if (dd < 10) {
    dd = "0" + dd;
  }
  if (mm < 10) {
    mm = "0" + mm;
  }
  var today = dd + "/" + mm + "/" + yyyy;
  return today;
}

