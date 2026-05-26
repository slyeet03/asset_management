package com.fam.dao;
//package com.fam.dao;
//
//import java.util.Date;
//import java.util.List;
//
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fam.entity.Usermaster;
//
//public interface UserMasterDaoUsingShortcutQuery extends JpaRepository<Usermaster, String>{
//	Usermaster findByUserid(String userid);
//    List<Usermaster> findByRecstatus(String recstatus);
//    List<Usermaster> findAll();
//    
//    @Modifying
//    @Transactional 
//    @Query("UPDATE Usermaster u SET u.loggedin=:zero")
//    int releaseAllUsers(@Param("zero") Character zero);
//    
//    @Modifying
//    @Transactional 
//    @Query("UPDATE Usermaster u SET u.locked=NULL,u.lockedreason=NULL,u.loggedin=0,u.attempcount=NULL,u.recstatus=5,"
//    		+ "u.makerdate=:currentDate,u.makertime=:currentTime,u.makerip=:userIp,u.makerid=:userId where userid=:userId")
//    int UnLockUser(@Param("currentDate") Date currentDate,
//	  @Param("currentTime") String currentTime,@Param("userIp") String userIp,@Param("userId") String userId);
//
//    @Modifying
//    @Transactional 
//    @Query("UPDATE Usermaster u SET u.pwd=:pwd, u.locked=NULL,u.lockedreason=NULL,u.loggedin=0,u.attempcount=NULL,u.recstatus=5,"
//    		+ "u.makerdate=:currentDate,u.makertime=:currentTime,u.makerip=:userIp,u.makerid=:userId where userid=:userId")
//    int resetPassword(@Param("pwd") String pwd,@Param("currentDate") Date currentDate,
//	  @Param("currentTime") String currentTime,@Param("userIp") String userIp,@Param("userId") String userId);
//    
//}
