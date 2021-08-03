/*
Navicat MariaDB Data Transfer

Source Server         : mooncenter
Source Server Version : 100216
Source Host           : 192.168.1.202:3307
Source Database       : micc

Target Server Type    : MariaDB
Target Server Version : 100216
File Encoding         : 65001

Date: 2018-09-12 17:47:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announce
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `titlename` varchar(36) DEFAULT NULL COMMENT '标题名称',
  `detils` varchar(255) DEFAULT NULL COMMENT '公告详细内容',
  `create_man` varchar(25) DEFAULT NULL COMMENT '创建人',
  `publish_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(32) DEFAULT NULL COMMENT '客户姓名',
  `tell` varchar(11) DEFAULT NULL COMMENT '客户电话',
  `sex` varchar(2) DEFAULT NULL COMMENT '客户性别',
  `number` int(2) DEFAULT NULL COMMENT '预计人数',
  `cometime` datetime DEFAULT NULL COMMENT '预计参访时间',
  `store_id` varchar(36) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for babynursingrecord
-- ----------------------------
DROP TABLE IF EXISTS `babynursingrecord`;
CREATE TABLE `babynursingrecord` (
  `id` varchar(36) NOT NULL COMMENT '宝宝护理纪录单id',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `room` varchar(30) DEFAULT NULL COMMENT '入住房间号',
  `mother` varchar(20) DEFAULT NULL COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for babynursingrecorddetail
-- ----------------------------
DROP TABLE IF EXISTS `babynursingrecorddetail`;
CREATE TABLE `babynursingrecorddetail` (
  `id` varchar(36) NOT NULL COMMENT '宝宝护理纪录明细单id',
  `babyNursingRecord_id` varchar(36) DEFAULT NULL COMMENT '纪录表头id',
  `temperature` varchar(20) DEFAULT '' COMMENT '体温',
  `pulse` varchar(20) DEFAULT '' COMMENT '脉搏',
  `breathing` varchar(20) DEFAULT '' COMMENT '呼吸',
  `weight` varchar(20) DEFAULT '' COMMENT '体重',
  `jaundice` varchar(20) DEFAULT '' COMMENT '黄疸',
  `nursingRecord` varchar(100) DEFAULT '' COMMENT '护理纪录内容',
  `updateTime` datetime DEFAULT NULL COMMENT '操作时间',
  `motherId` varchar(36) DEFAULT '' COMMENT '妈妈id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `bobyname` varchar(20) DEFAULT '' COMMENT '宝宝姓名',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  `room` varchar(20) DEFAULT '' COMMENT '房间号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for babywash
-- ----------------------------
DROP TABLE IF EXISTS `babywash`;
CREATE TABLE `babywash` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `babyname` varchar(20) DEFAULT '' COMMENT '宝宝姓名',
  `babyid` varchar(50) DEFAULT '' COMMENT '宝宝id',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  `motherid` varchar(50) DEFAULT '' COMMENT '妈妈id',
  `washway` varchar(10) DEFAULT NULL COMMENT '洗澡方式',
  `washdate` datetime DEFAULT NULL COMMENT '洗澡日期',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  `babyfrom` varchar(20) DEFAULT NULL COMMENT '宝宝来源',
  `storeid` varchar(50) DEFAULT '' COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for baby_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `baby_evaluate`;
CREATE TABLE `baby_evaluate` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '婴儿护理Id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id,外键',
  `room_id` varchar(30) DEFAULT NULL COMMENT '入住房间号',
  `hospitalSummary` varchar(30) DEFAULT NULL COMMENT '提供出院小结',
  `child_birth_way` varchar(20) DEFAULT NULL COMMENT '分娩方式',
  `weight` varchar(20) DEFAULT NULL COMMENT '体重',
  `height` varchar(20) DEFAULT NULL COMMENT '身高',
  `temperature` varchar(20) DEFAULT NULL COMMENT '体温',
  `heartbeat` varchar(20) DEFAULT NULL COMMENT '心跳',
  `breathing` varchar(20) DEFAULT NULL COMMENT '呼吸',
  `chimney` varchar(20) DEFAULT NULL COMMENT '囱头',
  `scalp` varchar(20) DEFAULT NULL COMMENT '头皮',
  `eye` varchar(20) DEFAULT NULL COMMENT '眼',
  `ear` varchar(20) DEFAULT NULL COMMENT '耳朵',
  `oral` varchar(20) DEFAULT NULL COMMENT '口腔',
  `nose` varchar(20) DEFAULT NULL COMMENT '鼻子',
  `neck` varchar(20) DEFAULT NULL COMMENT '颈部',
  `chest` varchar(20) DEFAULT NULL COMMENT '胸部',
  `abdomen` varchar(20) DEFAULT NULL COMMENT '腹部',
  `umbilical_cord` varchar(20) DEFAULT NULL COMMENT '脐带',
  `back` varchar(20) DEFAULT NULL COMMENT '背部',
  `upper_limb` varchar(20) DEFAULT NULL COMMENT '上肢',
  `lower_limbs` varchar(20) DEFAULT NULL COMMENT '下肢',
  `skin` varchar(20) DEFAULT NULL COMMENT '皮肤',
  `appearance` varchar(20) DEFAULT NULL COMMENT '外观',
  `secretions` varchar(20) DEFAULT '' COMMENT '分泌物',
  `move_bowels` varchar(20) DEFAULT NULL COMMENT '大便',
  `urinate` varchar(20) DEFAULT NULL COMMENT '小便',
  `assessment` varchar(20) DEFAULT NULL COMMENT '评估人',
  `confirm_signature` varchar(20) DEFAULT '' COMMENT '更改为妈妈姓名',
  `assessment_time` datetime DEFAULT NULL COMMENT '评估时间',
  `updateTime` datetime DEFAULT NULL COMMENT '操作时间',
  `note` varchar(120) DEFAULT NULL COMMENT '备注',
  `babyname` varchar(20) DEFAULT '' COMMENT '宝宝姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for callrecord
-- ----------------------------
DROP TABLE IF EXISTS `callrecord`;
CREATE TABLE `callrecord` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(36) DEFAULT NULL COMMENT '来电人姓名',
  `tell` varchar(11) DEFAULT NULL COMMENT '来电人电话',
  `forwhom` varchar(10) DEFAULT NULL COMMENT '替谁询问',
  `way` varchar(12) DEFAULT NULL COMMENT '得知途径',
  `personnel` varchar(10) DEFAULT NULL COMMENT '客服人员',
  `take_time` datetime DEFAULT NULL COMMENT '接听时间',
  `update_time` datetime DEFAULT NULL COMMENT '操作时间',
  `is_registration` varchar(2) DEFAULT NULL COMMENT '是否已追踪',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `id` varchar(50) NOT NULL,
  `customer_id` varchar(36) NOT NULL COMMENT '客户id',
  `contract_id` varchar(50) DEFAULT '' COMMENT '合同id',
  `status` varchar(100) NOT NULL COMMENT '入住状态',
  `room_id` varchar(50) NOT NULL COMMENT '房间id',
  `begin_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `create_id` varchar(36) DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for check_out
-- ----------------------------
DROP TABLE IF EXISTS `check_out`;
CREATE TABLE `check_out` (
  `id` varchar(50) NOT NULL,
  `customer_id` varchar(50) NOT NULL COMMENT '客户id',
  `room_id` varchar(50) NOT NULL COMMENT '房间id',
  `all_cost` varchar(100) DEFAULT '' COMMENT '总费用',
  `balance` varchar(100) DEFAULT '' COMMENT '余额',
  `out_time` datetime DEFAULT NULL COMMENT '退房时间',
  `creater_id` varchar(50) DEFAULT '' COMMENT '创建用户',
  `meal_fee` varchar(100) DEFAULT '' COMMENT '用餐费用',
  `add_service_fee` varchar(100) DEFAULT '' COMMENT '加值服务费用',
  `shopping_fee` varchar(100) DEFAULT '' COMMENT '购物费用',
  `coupons` varchar(100) DEFAULT '' COMMENT '优惠费用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `store_id` varchar(36) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '妈妈姓名',
  `tell` varchar(11) DEFAULT NULL COMMENT '电话',
  `height` int(5) DEFAULT NULL COMMENT '宝宝体重（克）',
  `babybirth` datetime DEFAULT NULL COMMENT '生产日期',
  `sex` varchar(2) DEFAULT NULL COMMENT '宝宝性别',
  `birthindex` int(11) DEFAULT NULL COMMENT '胎数',
  `method` varchar(10) DEFAULT NULL COMMENT '生产方式（剖宫，顺产）',
  `hospital` varchar(32) DEFAULT NULL COMMENT '生产医院',
  `doctor` varchar(32) DEFAULT NULL COMMENT '医师',
  `intime` datetime DEFAULT NULL COMMENT '预住时间',
  `outtime` datetime DEFAULT NULL COMMENT '预计离馆时间',
  `sickroom` varchar(32) DEFAULT NULL COMMENT '在院病房',
  `room_num` varchar(32) DEFAULT NULL COMMENT '预定会所房间号',
  `days` int(3) DEFAULT NULL COMMENT '订房天数',
  `liaison` varchar(10) DEFAULT NULL COMMENT '联络人',
  `liaisontell` varchar(11) DEFAULT NULL COMMENT '联络人电话',
  `Relation` varchar(10) DEFAULT NULL COMMENT '关系',
  `Callintime` datetime DEFAULT NULL COMMENT '接获通知时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for coupons
-- ----------------------------
DROP TABLE IF EXISTS `coupons`;
CREATE TABLE `coupons` (
  `id` varchar(50) NOT NULL,
  `source` varchar(100) DEFAULT '' COMMENT '来自哪位会员妈妈',
  `how_mouch` varchar(100) DEFAULT '' COMMENT '额度多少',
  `customer_basic_id` varchar(100) DEFAULT '' COMMENT '产妇id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for credentials
-- ----------------------------
DROP TABLE IF EXISTS `credentials`;
CREATE TABLE `credentials` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `other_id` varchar(36) DEFAULT NULL COMMENT '证件所属id（门店id/员工id）',
  `name` varchar(10) DEFAULT NULL COMMENT '证件名称',
  `address` varchar(55) DEFAULT '' COMMENT '证件图片地址',
  `cardid` varchar(36) DEFAULT '' COMMENT '证件号',
  `uptime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_basic
-- ----------------------------
DROP TABLE IF EXISTS `customer_basic`;
CREATE TABLE `customer_basic` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '客户Id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店Id',
  `name` varchar(36) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` varchar(10) DEFAULT NULL COMMENT '年龄',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `born_hospital` varchar(50) DEFAULT NULL COMMENT '入住医院',
  `type` varchar(20) DEFAULT '' COMMENT '类型(妈妈0/宝宝1)',
  `weight` varchar(30) DEFAULT NULL COMMENT '体重',
  `height` varchar(30) DEFAULT NULL COMMENT '身高',
  `contact` varchar(30) DEFAULT NULL COMMENT '联系方式',
  `update_time` datetime DEFAULT NULL COMMENT 'updateTime',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `leader` varchar(25) DEFAULT NULL COMMENT '部门负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employer
-- ----------------------------
DROP TABLE IF EXISTS `employer`;
CREATE TABLE `employer` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '员工id',
  `store_file_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `institution` varchar(60) DEFAULT NULL COMMENT '所属机构',
  `department` varchar(50) NOT NULL COMMENT '所在部门',
  `name` varchar(36) NOT NULL COMMENT '员工姓名',
  `sex` varchar(2) NOT NULL COMMENT '员工性别',
  `position` varchar(10) DEFAULT NULL COMMENT '职位',
  `position_num` varchar(36) DEFAULT NULL COMMENT '岗位编号',
  `tell` varchar(11) NOT NULL COMMENT '电话',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限',
  `birthplace` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `card_id` varchar(18) DEFAULT NULL COMMENT '身份证',
  `work_id` varchar(36) DEFAULT NULL COMMENT '工作证件号',
  `banknum` varchar(21) DEFAULT NULL COMMENT '工资卡号',
  `critical_person` varchar(10) DEFAULT NULL COMMENT '紧急联络人',
  `critical_tell` varchar(11) DEFAULT NULL COMMENT '紧急联络人电话',
  `email` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `type` varchar(2) DEFAULT NULL COMMENT '类型（1/门店员工 0/派遣人员）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for extra_service
-- ----------------------------
DROP TABLE IF EXISTS `extra_service`;
CREATE TABLE `extra_service` (
  `id` varchar(50) NOT NULL,
  `project` varchar(100) DEFAULT '' COMMENT '增值服务项目名',
  `vendor` varchar(100) DEFAULT '' COMMENT '提供厂商',
  `charges` varchar(100) DEFAULT '' COMMENT '加值服务费用',
  `phone` varchar(100) DEFAULT '' COMMENT '厂商联系方式',
  `store_file_id` varchar(36) DEFAULT '' COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` varchar(36) NOT NULL COMMENT '商品id',
  `goods_name` varchar(36) DEFAULT NULL COMMENT '商品名称',
  `unit` varchar(10) DEFAULT NULL COMMENT '商品单位',
  `price_one` double(10,2) DEFAULT NULL COMMENT '分公司单价',
  `goods_one_id` varchar(36) DEFAULT NULL COMMENT '物资一级分类表id',
  `goods_two_id` varchar(36) DEFAULT NULL COMMENT '物资二级分类表id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商Id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `serialnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `price_two` double(10,0) DEFAULT NULL COMMENT '门店单价',
  `alliasname` varchar(36) DEFAULT NULL COMMENT '别名',
  `specifications` varchar(36) DEFAULT NULL COMMENT '规格',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialnum` (`serialnum`) COMMENT '物品编号'
) ENGINE=InnoDB AUTO_INCREMENT=242552 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_one
-- ----------------------------
DROP TABLE IF EXISTS `goods_one`;
CREATE TABLE `goods_one` (
  `id` varchar(36) NOT NULL COMMENT '物资一级分类表id',
  `classify_one` varchar(15) NOT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `id` varchar(36) NOT NULL,
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  `employer_id` varchar(36) DEFAULT NULL COMMENT '员工id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `status` int(5) DEFAULT NULL COMMENT '订单状态（0预定，1下单，2入库）',
  `ordertime` datetime DEFAULT NULL COMMENT '下单时间',
  `applicationtime` datetime DEFAULT NULL COMMENT '申请时间',
  `tell` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `sumprice` double(10,2) DEFAULT NULL COMMENT '总价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_two
-- ----------------------------
DROP TABLE IF EXISTS `goods_two`;
CREATE TABLE `goods_two` (
  `id` varchar(36) NOT NULL COMMENT '物资二级分类表id',
  `goods_one_id` varchar(36) NOT NULL COMMENT '物资一级分类表id',
  `classify_two` varchar(15) DEFAULT '' COMMENT '二级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for growthrecord
-- ----------------------------
DROP TABLE IF EXISTS `growthrecord`;
CREATE TABLE `growthrecord` (
  `id` varchar(36) NOT NULL COMMENT '宝宝成长纪录表',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `recordDate` datetime DEFAULT NULL COMMENT '纪录时间',
  `project` varchar(20) DEFAULT '' COMMENT '项目类型',
  `temperature` varchar(20) DEFAULT '' COMMENT '体温',
  `weight` varchar(20) DEFAULT '' COMMENT '体重',
  `milk` varchar(20) DEFAULT '' COMMENT '奶量',
  `defecateFrequency` varchar(20) DEFAULT '' COMMENT '大便次数',
  `jaundice` varchar(20) DEFAULT '' COMMENT '黄疸指数',
  `motherId` varchar(36) DEFAULT '' COMMENT '妈妈id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `babyname` varchar(20) DEFAULT '' COMMENT '宝宝姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for guest_record
-- ----------------------------
DROP TABLE IF EXISTS `guest_record`;
CREATE TABLE `guest_record` (
  `id` varchar(50) NOT NULL,
  `department` int(11) DEFAULT NULL COMMENT '投诉部门（护理部1，房务部2，厨房部3，房务部4）',
  `reporter` varchar(100) DEFAULT '' COMMENT '报告人',
  `reporttile` varchar(100) DEFAULT '' COMMENT '事件报告标题',
  `eventtime` datetime DEFAULT NULL COMMENT '事件发生时间',
  `reporttime` datetime DEFAULT NULL COMMENT '报告时间',
  `detail` varchar(100) DEFAULT '' COMMENT '过程描述及原因',
  `cause` varchar(100) DEFAULT '' COMMENT '发生客诉事件原因',
  `solution` varchar(100) DEFAULT '' COMMENT '解决方案',
  `result` varchar(100) DEFAULT '' COMMENT '事件处理结果',
  `leaderidea` varchar(100) DEFAULT '' COMMENT '领导处理意见',
  `store_file_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT '' COMMENT '物品名称',
  `number` varchar(100) DEFAULT '' COMMENT '物品数量',
  `remarks` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for items_use
-- ----------------------------
DROP TABLE IF EXISTS `items_use`;
CREATE TABLE `items_use` (
  `id` varchar(50) NOT NULL,
  `customer_id` varchar(36) NOT NULL COMMENT '客户id',
  `items_id` varchar(50) NOT NULL DEFAULT '' COMMENT '物品id',
  `number` varchar(50) DEFAULT '' COMMENT '使用数量',
  `remarks` varchar(100) DEFAULT '' COMMENT '备注',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `creater_id` varchar(50) DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mealmanager
-- ----------------------------
DROP TABLE IF EXISTS `mealmanager`;
CREATE TABLE `mealmanager` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `motherid` varchar(36) DEFAULT '' COMMENT '妈妈id',
  `familymealcount` int(11) DEFAULT 0 COMMENT '家属餐数量',
  `breakfast` int(11) DEFAULT 0 COMMENT '早餐',
  `lunch` int(11) DEFAULT 0 COMMENT '午餐',
  `dinner` int(11) DEFAULT 0 COMMENT '晚餐',
  `mealdate` datetime DEFAULT NULL COMMENT '用餐日期',
  `roomid` varchar(36) DEFAULT '' COMMENT '房间id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for meetingrecord
-- ----------------------------
DROP TABLE IF EXISTS `meetingrecord`;
CREATE TABLE `meetingrecord` (
  `id` varchar(50) NOT NULL,
  `store_file_id` varchar(50) DEFAULT '' COMMENT '店铺id',
  `department` varchar(100) DEFAULT '' COMMENT '部门',
  `meetingTime` datetime DEFAULT NULL COMMENT '会议地点',
  `place` varchar(100) DEFAULT '' COMMENT '地点',
  `attendees` varchar(100) DEFAULT '' COMMENT '出席人员',
  `absencepersonnel` varchar(100) DEFAULT '' COMMENT '缺席人员',
  `host` varchar(100) DEFAULT '' COMMENT '主持人',
  `recorder` varchar(100) DEFAULT '' COMMENT '记录人',
  `meetingcontent` varchar(100) DEFAULT '' COMMENT '会议内容',
  `note` varchar(100) DEFAULT '' COMMENT '备注',
  `signature` varchar(100) DEFAULT '' COMMENT '阅后签名',
  `endtime` datetime DEFAULT NULL COMMENT '会议结束时间',
  `nexttime` datetime DEFAULT NULL COMMENT '下期会议时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for member_manager
-- ----------------------------
DROP TABLE IF EXISTS `member_manager`;
CREATE TABLE `member_manager` (
  `id` varchar(50) NOT NULL,
  `store_id` varchar(50) DEFAULT '' COMMENT '所在门店id',
  `membername` varchar(100) DEFAULT '' COMMENT '会员姓名',
  `leavetime` datetime DEFAULT NULL COMMENT '离馆时间',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  `phone` varchar(100) DEFAULT '' COMMENT '手机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mothernursingrecorddetail
-- ----------------------------
DROP TABLE IF EXISTS `mothernursingrecorddetail`;
CREATE TABLE `mothernursingrecorddetail` (
  `id` varchar(36) NOT NULL COMMENT '产妇护理纪录明细表id',
  `nursingRecord_id` varchar(36) DEFAULT NULL COMMENT '护理纪录id',
  `nursingDate` datetime NOT NULL COMMENT '护理时间',
  `content` varchar(120) NOT NULL COMMENT '护理内容',
  `note` varchar(120) DEFAULT '' COMMENT '备注',
  `customer_name` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for motherworryquestion
-- ----------------------------
DROP TABLE IF EXISTS `motherworryquestion`;
CREATE TABLE `motherworryquestion` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  `answerone` varchar(20) DEFAULT '' COMMENT '答案1',
  `answertwo` varchar(20) DEFAULT '' COMMENT '答案2',
  `answerthree` varchar(20) DEFAULT '' COMMENT '答案3',
  `answerfour` varchar(20) DEFAULT '' COMMENT '答案4',
  `answerfive` varchar(20) DEFAULT '' COMMENT '答案5',
  `answersix` varchar(20) DEFAULT '' COMMENT '答案6',
  `answerseven` varchar(20) DEFAULT '' COMMENT '答案7',
  `answereight` varchar(20) DEFAULT '' COMMENT '答案8',
  `answernine` varchar(20) DEFAULT '' COMMENT '答案9',
  `answerten` varchar(20) DEFAULT '' COMMENT '答案10',
  `storeid` varchar(50) DEFAULT '' COMMENT '门店id',
  `motherid` varchar(50) DEFAULT '' COMMENT '妈妈id',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `store` varchar(5) DEFAULT '' COMMENT '分数',
  `age` varchar(5) DEFAULT '' COMMENT '年龄',
  `roomnumber` varchar(5) DEFAULT '' COMMENT '房间号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mother_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `mother_evaluate`;
CREATE TABLE `mother_evaluate` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '评估Id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `customer_basic_id` varchar(36) DEFAULT '' COMMENT '客户id',
  `room_id` varchar(36) DEFAULT NULL COMMENT '入住房间号',
  `bad_no` varchar(30) DEFAULT NULL COMMENT '床号',
  `child_time` varchar(30) DEFAULT NULL COMMENT '胎次',
  `weight_increase` int(11) DEFAULT NULL COMMENT '体重增加',
  `pregnancy` varchar(50) DEFAULT NULL COMMENT '妊娠合并症',
  `child_birth_way` varchar(50) DEFAULT NULL COMMENT '分娩方式',
  `pph` varchar(10) DEFAULT NULL COMMENT 'PPH',
  `tear` varchar(10) DEFAULT NULL COMMENT '撕裂伤',
  `t` varchar(30) DEFAULT NULL COMMENT 't',
  `p` varchar(30) DEFAULT NULL COMMENT 'p',
  `r` varchar(30) DEFAULT NULL COMMENT 'r',
  `bp` varchar(30) DEFAULT NULL COMMENT 'bp',
  `uterus_height` varchar(20) DEFAULT NULL COMMENT '子宫底高度',
  `uterus_hardness` varchar(20) DEFAULT NULL COMMENT '子宫底软硬度',
  `lochia` varchar(20) DEFAULT NULL COMMENT '恶露',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `character1` varchar(20) DEFAULT '' COMMENT '性状',
  `taste` varchar(20) DEFAULT NULL COMMENT '味道',
  `perineum_wound` varchar(20) DEFAULT NULL COMMENT '会阴伤口',
  `cesarean_wound` varchar(20) DEFAULT NULL COMMENT '剖腹产伤口',
  `breast` varchar(20) DEFAULT NULL COMMENT '乳房',
  `nipple` varchar(20) DEFAULT NULL COMMENT '乳头',
  `mastitis` varchar(20) DEFAULT NULL COMMENT '乳腺炎',
  `secretion` varchar(20) DEFAULT NULL COMMENT '乳汁分泌',
  `hemorrhoids` varchar(20) DEFAULT NULL COMMENT '痔疮',
  `defecation` varchar(20) DEFAULT NULL COMMENT '排便情况',
  `infectious_diseases` varchar(20) DEFAULT '' COMMENT '传染病',
  `extra_medications` varchar(20) DEFAULT '' COMMENT '备用药物',
  `mental_state` varchar(20) DEFAULT '' COMMENT '精神状态',
  `edema_state` varchar(20) DEFAULT '' COMMENT '水肿状态',
  `emotional_state` varchar(20) DEFAULT '' COMMENT '情绪状态',
  `assessment` varchar(20) DEFAULT NULL COMMENT '评估人',
  `assessment_time` datetime DEFAULT NULL COMMENT '评估时间',
  `update_time` datetime DEFAULT NULL COMMENT '操作时间',
  `note` varchar(120) DEFAULT NULL COMMENT '备注',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for neonatalrounds
-- ----------------------------
DROP TABLE IF EXISTS `neonatalrounds`;
CREATE TABLE `neonatalrounds` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id,外键',
  `operation_date` datetime DEFAULT NULL COMMENT '查房日期',
  `roomnum` varchar(36) DEFAULT NULL COMMENT '房间号',
  `bornway` varchar(50) DEFAULT NULL COMMENT '出生方式',
  `pregnancy` varchar(50) DEFAULT NULL COMMENT '孕周',
  `feedingway` varchar(50) DEFAULT NULL COMMENT '喂养方式',
  `milkeveryday` varchar(50) DEFAULT NULL COMMENT '每日奶量',
  `reaction` varchar(50) DEFAULT NULL COMMENT '反应',
  `skin` varchar(50) DEFAULT NULL COMMENT '皮肤',
  `headfeatures` varchar(50) DEFAULT NULL COMMENT '头部五官',
  `cardiopulmonary` varchar(100) DEFAULT NULL COMMENT '心肺',
  `abdomen` varchar(100) DEFAULT NULL COMMENT '腹部',
  `umbilical` varchar(100) DEFAULT NULL COMMENT '脐带',
  `extremities` varchar(100) DEFAULT NULL COMMENT '四肢关节',
  `nervereflex` varchar(100) DEFAULT NULL COMMENT '神经反射',
  `fecal` varchar(100) DEFAULT NULL COMMENT '粪便',
  `other_situations` varchar(255) DEFAULT NULL COMMENT '其它情况',
  `advice` varchar(255) DEFAULT NULL COMMENT '医嘱',
  `signature` varchar(50) DEFAULT NULL COMMENT '医师签字',
  `mother_id` varchar(36) DEFAULT NULL COMMENT '妈妈id',
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  `baby` varchar(20) DEFAULT '',
  `mothername` varchar(20) DEFAULT '' COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for nurse_record
-- ----------------------------
DROP TABLE IF EXISTS `nurse_record`;
CREATE TABLE `nurse_record` (
  `id` varchar(36) NOT NULL COMMENT '产妇护理纪录表id',
  `customer_basic_id` varchar(36) NOT NULL COMMENT '客户id',
  `productionDate` datetime NOT NULL COMMENT '生产日期',
  `modeProduction` varchar(20) DEFAULT NULL COMMENT '生产方式',
  `feeding` varchar(20) DEFAULT NULL COMMENT '喂养方式',
  `customerName` varchar(20) NOT NULL COMMENT '客户姓名',
  `store_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for nursingeducation
-- ----------------------------
DROP TABLE IF EXISTS `nursingeducation`;
CREATE TABLE `nursingeducation` (
  `id` varchar(36) NOT NULL COMMENT '产后护理卫教表id',
  `customer_basic_id` varchar(36) NOT NULL COMMENT '客户id',
  `project` varchar(50) NOT NULL COMMENT '评量项目',
  `behaviorObjectives` varchar(100) NOT NULL DEFAULT '' COMMENT '个别行为目标',
  `guideDate` datetime NOT NULL COMMENT '指导日期',
  `familySignature` varchar(30) NOT NULL COMMENT '家属签名',
  `mentorSignature` varchar(30) NOT NULL COMMENT '指导者签名',
  `evaluationDate` datetime NOT NULL COMMENT '评量日期',
  `EvaluationResult` varchar(50) NOT NULL COMMENT '评量结果',
  `evaluationSignature` varchar(30) NOT NULL COMMENT '评量者签名',
  `note` varchar(120) DEFAULT '' COMMENT '备注',
  `customerName` varchar(20) NOT NULL COMMENT '客户姓名',
  `store_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_customer
-- ----------------------------
DROP TABLE IF EXISTS `order_customer`;
CREATE TABLE `order_customer` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `store_id` varchar(36) DEFAULT NULL,
  `first_party` varchar(10) DEFAULT NULL COMMENT '甲方',
  `Card_id` varchar(18) DEFAULT NULL COMMENT '甲方身份证',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `tell` varchar(11) DEFAULT NULL COMMENT '电话',
  `Medical_history` varchar(2) DEFAULT NULL COMMENT '有无病史（是，否）',
  `intime` datetime DEFAULT NULL COMMENT '预定入住时间',
  `days` int(3) DEFAULT NULL COMMENT '订房天数',
  `room_type` varchar(10) DEFAULT NULL COMMENT '预定房型',
  `room_number` varchar(10) DEFAULT NULL COMMENT '预定会所房间号',
  `price` double(9,0) DEFAULT NULL COMMENT '总费用',
  `bargain_money` double(9,0) DEFAULT NULL COMMENT '定金',
  `pay_way` varchar(255) DEFAULT NULL COMMENT '支付方式（现金，转账）',
  `final_payment` double(9,0) DEFAULT NULL COMMENT '尾款',
  `final_payment_status` varchar(10) DEFAULT NULL COMMENT '尾款状态（已支付，未支付）',
  `operator` varchar(10) DEFAULT NULL COMMENT '经办人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `id` varchar(36) NOT NULL COMMENT '订单详情表id',
  `goods_id` varchar(36) DEFAULT NULL COMMENT '商品id',
  `goods_num` double(10,0) DEFAULT NULL COMMENT '商品数量',
  `price` double(10,2) DEFAULT NULL COMMENT '商品单价',
  `order_id` varchar(36) DEFAULT NULL COMMENT '订单id',
  `detailstype` int(10) DEFAULT NULL COMMENT '类别（0：订单详情 1：入货详情2：出货详情）',
  `serialnum` int(10) DEFAULT NULL COMMENT '商品编号（唯一）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_room
-- ----------------------------
DROP TABLE IF EXISTS `order_room`;
CREATE TABLE `order_room` (
  `id` varchar(50) NOT NULL,
  `room_id` varchar(100) DEFAULT '' COMMENT '房间id',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `price` varchar(100) DEFAULT '' COMMENT '价格',
  `creater_id` varchar(100) DEFAULT '' COMMENT '创建用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for patientrounds
-- ----------------------------
DROP TABLE IF EXISTS `patientrounds`;
CREATE TABLE `patientrounds` (
  `id` varchar(36) NOT NULL COMMENT '医生查房表',
  `customer_basic_id` varchar(36) NOT NULL COMMENT '客户id',
  `operationDate` datetime NOT NULL COMMENT '查房日期',
  `shrinkage` varchar(50) DEFAULT NULL COMMENT '子宫收缩情况',
  `cesareanSection` varchar(50) DEFAULT NULL COMMENT '剖腹产术后刀口',
  `sideCutter` varchar(50) DEFAULT NULL COMMENT '侧切刀情况',
  `lochiaColor` varchar(50) DEFAULT '' COMMENT '恶露颜色',
  `lochiaSmell` varchar(50) DEFAULT '' COMMENT '恶露气味',
  `leucorrhea` varchar(50) DEFAULT '' COMMENT '白带情况',
  `fever` varchar(50) DEFAULT '' COMMENT '有无发热',
  `signature` varchar(50) DEFAULT '' COMMENT '医师签字',
  `otherSituations` varchar(150) DEFAULT NULL COMMENT '其它情况',
  `customerName` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `motherId` varchar(36) DEFAULT NULL,
  `store_id` varchar(36) DEFAULT NULL,
  `type` varchar(10) DEFAULT '' COMMENT '类别（本条记录是妈妈或者宝宝）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pavilionassessment
-- ----------------------------
DROP TABLE IF EXISTS `pavilionassessment`;
CREATE TABLE `pavilionassessment` (
  `id` varchar(36) NOT NULL COMMENT '宝宝出馆评估表id',
  `customer_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `mother` varchar(30) DEFAULT '' COMMENT '母亲',
  `father` varchar(30) DEFAULT '' COMMENT '父亲',
  `pavilionDate` datetime DEFAULT NULL COMMENT '出馆时间',
  `status` varchar(20) DEFAULT '' COMMENT '状况',
  `scalp` varchar(20) DEFAULT '' COMMENT '头皮',
  `eye` varchar(20) DEFAULT '' COMMENT '眼',
  `ear` varchar(20) DEFAULT '' COMMENT '耳朵',
  `oral` varchar(20) DEFAULT '' COMMENT '口腔',
  `nose` varchar(20) DEFAULT '' COMMENT '鼻子',
  `cheek` varchar(20) DEFAULT '' COMMENT '面颊',
  `chest` varchar(20) DEFAULT '' COMMENT '胸部',
  `abdomen` varchar(20) DEFAULT '' COMMENT '腹部',
  `umbilicalCord` varchar(20) DEFAULT '' COMMENT '脐带',
  `genital` varchar(20) DEFAULT '' COMMENT '生殖器',
  `limbs` varchar(20) DEFAULT '' COMMENT '四肢',
  `informObjece` varchar(20) DEFAULT '' COMMENT '告知对象',
  `assessmentTime` datetime DEFAULT NULL COMMENT '评估时间',
  `motherId` varchar(36) DEFAULT NULL,
  `store_id` varchar(36) DEFAULT NULL,
  `babyname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pavilioneducation
-- ----------------------------
DROP TABLE IF EXISTS `pavilioneducation`;
CREATE TABLE `pavilioneducation` (
  `id` varchar(36) NOT NULL COMMENT '离馆卫教表id',
  `customer_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `pavilionWeight` varchar(10) DEFAULT '' COMMENT '出馆体重',
  `stayWeight` varchar(10) DEFAULT '' COMMENT '入住体重',
  `bornWeight` varchar(10) DEFAULT '' COMMENT '出生体重',
  `temperature` varchar(20) DEFAULT '' COMMENT '体温',
  `heartbeat` varchar(20) DEFAULT '' COMMENT '心跳',
  `milkinterval` varchar(20) DEFAULT '' COMMENT '奶量',
  `howlong` varchar(20) DEFAULT '' COMMENT '多久喂奶一次',
  `onFeeding` datetime DEFAULT NULL COMMENT '上次喂奶时间',
  `underFeeding` datetime DEFAULT NULL COMMENT '下次喂奶时间',
  `temperatures` varchar(10) DEFAULT '' COMMENT '温奶温度',
  `familyMembers` varchar(20) DEFAULT '' COMMENT '家属签名',
  `nurse` varchar(20) DEFAULT '' COMMENT '护士签名',
  `motherId` varchar(20) DEFAULT NULL,
  `store_id` varchar(36) DEFAULT NULL,
  `babyname` varchar(20) DEFAULT NULL,
  `mothername` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(36) NOT NULL COMMENT '权限id',
  `permname` varchar(50) DEFAULT '' COMMENT '权限描述',
  `permtag` varchar(50) DEFAULT '' COMMENT '权限路径'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for preview
-- ----------------------------
DROP TABLE IF EXISTS `preview`;
CREATE TABLE `preview` (
  `id` varchar(36) NOT NULL,
  `room_id` varchar(36) DEFAULT '' COMMENT '房间id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `order_customer_id` varchar(36) DEFAULT '' COMMENT '客户订单id',
  `mother_name` varchar(10) DEFAULT '' COMMENT '妈妈姓名',
  `room_style` varchar(10) DEFAULT '' COMMENT '房间类型（温馨，VIP，豪华）',
  `status` varchar(10) DEFAULT '' COMMENT '房间状态（0：未使用  1：在使用2：预订）',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` varchar(36) NOT NULL COMMENT '进货表id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `goods_order_id` varchar(36) DEFAULT NULL COMMENT '进货订单id',
  `purchase_time` datetime DEFAULT NULL COMMENT '进货日期',
  `employer_id` varchar(36) DEFAULT NULL COMMENT '收货员工id',
  `payable` double(20,0) DEFAULT NULL COMMENT '应付金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `sort_id` varchar(36) DEFAULT '' COMMENT '问题的分类id(外键表',
  `detail` varchar(255) DEFAULT NULL COMMENT '问题内容',
  `answer` varchar(255) DEFAULT NULL COMMENT '问题答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for question_sort
-- ----------------------------
DROP TABLE IF EXISTS `question_sort`;
CREATE TABLE `question_sort` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `classification` varchar(32) DEFAULT NULL COMMENT '问题类别',
  `store_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL COMMENT '角色id ',
  `rolename` varchar(50) DEFAULT NULL COMMENT '角色名',
  `roledesc` varchar(50) DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `permission_id` varchar(36) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `room_styles_id` varchar(36) DEFAULT '' COMMENT '房型表id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `classify` varchar(10) DEFAULT NULL COMMENT '房间类型',
  `position` varchar(20) DEFAULT '' COMMENT '方位',
  `num` varchar(10) DEFAULT NULL COMMENT '房号',
  `area` varchar(12) DEFAULT NULL COMMENT '面积',
  `charge` int(11) DEFAULT NULL COMMENT '价钱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room_styles
-- ----------------------------
DROP TABLE IF EXISTS `room_styles`;
CREATE TABLE `room_styles` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `room_style` varchar(20) DEFAULT '' COMMENT '房间类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for satisfaction_record
-- ----------------------------
DROP TABLE IF EXISTS `satisfaction_record`;
CREATE TABLE `satisfaction_record` (
  `id` varchar(50) NOT NULL,
  `question1` int(11) DEFAULT NULL COMMENT '住房联系接洽人员态度(非常满意1，满意2，普通3，不满意4，非常不满意）',
  `question2` int(11) DEFAULT NULL COMMENT '交办事项处理的服务态度及效率',
  `question3` int(11) DEFAULT NULL COMMENT '客服人员服务态度',
  `question4` varchar(100) DEFAULT '' COMMENT '优秀客服人员推荐',
  `question5` int(11) DEFAULT NULL COMMENT '产前后课程活动内容实用度',
  `question6` int(11) DEFAULT NULL COMMENT '护理人员产后照护（伤口、恶露。。）',
  `question7` int(11) DEFAULT NULL COMMENT '护理人员母乳哺喂指导专业度',
  `question8` int(11) DEFAULT NULL COMMENT '育婴知识卫教指导',
  `question9` int(11) DEFAULT NULL COMMENT '护理人员服务态度',
  `question10` varchar(100) DEFAULT '' COMMENT '优秀护理人员推荐',
  `question11` int(11) DEFAULT NULL COMMENT '宝宝照顾专业度及技巧',
  `question12` int(11) DEFAULT NULL COMMENT '宝宝照护服务态度',
  `question13` int(11) DEFAULT NULL COMMENT '宝宝婴儿抚触',
  `question14` int(11) DEFAULT NULL COMMENT '餐点及饮品品质',
  `question15` int(11) DEFAULT NULL COMMENT '餐点菜色变化',
  `question16` int(11) DEFAULT NULL COMMENT '餐点口味（咸、淡）',
  `question17` int(11) DEFAULT NULL COMMENT '送餐人员服务态度',
  `question18` varchar(100) DEFAULT '' COMMENT '优秀送餐人员推荐',
  `question19` int(11) DEFAULT NULL COMMENT '清洁人员清洁工作确实度',
  `question20` int(11) DEFAULT NULL COMMENT '清洁人员服务态度',
  `question21` varchar(100) DEFAULT '' COMMENT '优秀清洁人员推荐',
  `question22` int(11) DEFAULT NULL COMMENT '此次坐月子的满意度',
  `question23` varchar(100) DEFAULT '' COMMENT '建议事项',
  `roomnum` varchar(100) DEFAULT '' COMMENT '房号',
  `mumname` varchar(100) DEFAULT '' COMMENT '妈妈姓名',
  `date` varchar(100) DEFAULT '' COMMENT '日期',
  `store_file_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for satisfaction_survey
-- ----------------------------
DROP TABLE IF EXISTS `satisfaction_survey`;
CREATE TABLE `satisfaction_survey` (
  `id` varchar(50) NOT NULL,
  `roomnum` varchar(100) DEFAULT '' COMMENT '房号',
  `mamname` varchar(100) DEFAULT '' COMMENT '妈妈姓名',
  `survey_type` int(11) DEFAULT NULL COMMENT '调查表类型（乳房护理满意度调查表1，美容美体满意度调查表2，满月照满意度调查表3）',
  `skills` varchar(11) DEFAULT '' COMMENT '专业技能满意程度（1非常满意/2满意/3一般/4不满意）',
  `attitude` varchar(11) DEFAULT '' COMMENT '服务态度满意程度（1/2/3/4）',
  `communication` varchar(11) DEFAULT '' COMMENT '服务中信息的交流（1/2/3/4）',
  `progess` varchar(11) DEFAULT '' COMMENT '服务中进度的掌握（1/2/3/4）',
  `solution` varchar(11) DEFAULT '' COMMENT '解决问题的情况（1/2/3/4）',
  `costumes` varchar(11) DEFAULT '' COMMENT '服装道具的提供（1/2/3/4）{满月照特有}',
  `time` varchar(11) DEFAULT '' COMMENT '对服务时长的满意度',
  `extraservice` varchar(11) DEFAULT '' COMMENT '是否提供额外服务',
  `consumption` varchar(11) DEFAULT '' COMMENT '对强制消费的满意度',
  `feedback` varchar(100) DEFAULT '' COMMENT '改进意见',
  `store_file_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` varchar(50) NOT NULL,
  `institution` varchar(100) DEFAULT '' COMMENT '所在机构',
  `department` varchar(30) DEFAULT '' COMMENT '所在部门（护理部1，房务部2，后厨3，客服4）',
  `type` varchar(30) DEFAULT '' COMMENT '班次类型(白班1，夜班2，休假3，请假4，外派5，医陪6)',
  `detailinfo` varchar(100) DEFAULT '' COMMENT '外派和医陪可备注具体信息',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `employid` varchar(100) DEFAULT '' COMMENT '职工id',
  `createdate` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for send_car
-- ----------------------------
DROP TABLE IF EXISTS `send_car`;
CREATE TABLE `send_car` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT 'id',
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  `name` varchar(32) DEFAULT NULL COMMENT '用车人姓名',
  `department` varchar(10) DEFAULT NULL COMMENT '用车部门',
  `start_time` datetime DEFAULT NULL COMMENT '发车时间',
  `passenger` varchar(255) DEFAULT NULL COMMENT '乘车人员',
  `route` varchar(100) DEFAULT NULL COMMENT '出行路线',
  `originator` varchar(10) DEFAULT NULL COMMENT '制单人',
  `time` datetime DEFAULT NULL COMMENT '制单时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shipments
-- ----------------------------
DROP TABLE IF EXISTS `shipments`;
CREATE TABLE `shipments` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `status` int(36) DEFAULT NULL COMMENT '类型（0：领用 1：销售）',
  `shipping_time` datetime DEFAULT NULL COMMENT '出货日期',
  `employer_id` varchar(36) DEFAULT NULL COMMENT '取货员工id',
  `receivable` double(20,0) DEFAULT NULL COMMENT '应收金额',
  `mother_id` varchar(36) DEFAULT NULL COMMENT '妈妈id',
  `room_id` varchar(36) DEFAULT NULL COMMENT '房间id',
  `mather_name` varchar(36) DEFAULT NULL COMMENT '妈妈姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `id` varchar(50) NOT NULL,
  `item_id` varchar(50) DEFAULT '' COMMENT '物品id',
  `shopping_time` datetime DEFAULT NULL COMMENT '购物时间',
  `price` varchar(100) DEFAULT '' COMMENT '价格',
  `pay_style` varchar(100) DEFAULT '' COMMENT '支付方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` varchar(36) NOT NULL COMMENT '库存表id',
  `goods_id` varchar(36) DEFAULT NULL COMMENT '商品id',
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商id',
  `stock_num` double(10,0) DEFAULT NULL COMMENT '库存数量',
  `stock_warn` double(10,0) DEFAULT NULL COMMENT '预警库存数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `purchase_num` double(10,0) DEFAULT NULL COMMENT '入库数量',
  `shipments_num` double(10,0) DEFAULT NULL COMMENT '出库数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storeservice
-- ----------------------------
DROP TABLE IF EXISTS `storeservice`;
CREATE TABLE `storeservice` (
  `id` varchar(50) NOT NULL,
  `motherid` varchar(50) DEFAULT NULL COMMENT '服务内容',
  `services` varchar(255) DEFAULT NULL,
  `storeid` varchar(50) DEFAULT NULL COMMENT '门店id',
  `mothername` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for store_file
-- ----------------------------
DROP TABLE IF EXISTS `store_file`;
CREATE TABLE `store_file` (
  `id` varchar(36) NOT NULL COMMENT '门店id',
  `name` varchar(15) DEFAULT NULL COMMENT '企业名称',
  `sort` varchar(10) DEFAULT '' COMMENT '企业分类（总公司/分公司/...）',
  `abbreviation` varchar(10) DEFAULT NULL COMMENT '机构简称',
  `property` varchar(36) DEFAULT NULL COMMENT '公司性质',
  `industry_nature` varchar(36) DEFAULT NULL COMMENT '行业性质',
  `institution_num` varchar(36) DEFAULT NULL COMMENT '机构编号',
  `institution` varchar(36) DEFAULT NULL COMMENT '所属机构',
  `established` datetime DEFAULT NULL COMMENT '成立时间',
  `leader` varchar(10) DEFAULT NULL COMMENT '负责人',
  `tell` varchar(11) DEFAULT NULL COMMENT '电话',
  `email` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `zip_code` varchar(10) DEFAULT NULL COMMENT '邮编',
  `account_name` varchar(36) DEFAULT NULL COMMENT '户名',
  `account_number` varchar(36) DEFAULT NULL COMMENT '账号',
  `bankname` varchar(55) DEFAULT NULL COMMENT '开户行',
  `store_id` varchar(36) DEFAULT NULL COMMENT '上级门店id',
  `profits` double(10,0) DEFAULT NULL COMMENT '利润',
  `expirationtime` datetime DEFAULT NULL COMMENT '截止日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` varchar(36) NOT NULL COMMENT '供应商表id',
  `supplier_name` varchar(32) NOT NULL COMMENT '供应商名称',
  `brand` varchar(15) DEFAULT '' COMMENT '品牌',
  `nature` varchar(20) DEFAULT '' COMMENT '个人/团体/工商',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  `tell` varchar(11) DEFAULT '' COMMENT '联系电话',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for swimming
-- ----------------------------
DROP TABLE IF EXISTS `swimming`;
CREATE TABLE `swimming` (
  `id` varchar(36) NOT NULL COMMENT '宝宝游泳记录表id',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `swim_time` datetime DEFAULT NULL,
  `weekday` varchar(10) DEFAULT '' COMMENT '周几',
  `swim_way` varchar(20) DEFAULT '' COMMENT '游泳方式（馆内游泳，馆外游泳，馆外洗澡）',
  `Identify` varchar(10) DEFAULT '' COMMENT '确认',
  `motherId` varchar(36) DEFAULT NULL,
  `store_id` varchar(36) DEFAULT NULL,
  `babyname` varchar(20) DEFAULT '',
  `mothername` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for temperature_register
-- ----------------------------
DROP TABLE IF EXISTS `temperature_register`;
CREATE TABLE `temperature_register` (
  `id` varchar(50) NOT NULL,
  `department` varchar(100) DEFAULT '' COMMENT '部门',
  `name` varchar(100) DEFAULT '' COMMENT '员工姓名',
  `sex` varchar(10) DEFAULT '' COMMENT '性别',
  `position` varchar(100) DEFAULT '' COMMENT '职位',
  `temperature` varchar(100) DEFAULT '' COMMENT '体温',
  `cough` varchar(100) DEFAULT '' COMMENT '咳嗽',
  `excepted` varchar(100) DEFAULT '' COMMENT '异常情况（备注）',
  `time` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `store_id` varchar(36) DEFAULT '' COMMENT '门店id',
  `logintype` varchar(25) DEFAULT NULL COMMENT '用户所属门店的等级分类',
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `password` varchar(250) DEFAULT '' COMMENT '密码',
  `realname` varchar(50) DEFAULT '' COMMENT '真实姓名',
  `sex` varchar(2) DEFAULT '' COMMENT '性别',
  `manroles` varchar(25) DEFAULT NULL COMMENT '角色',
  `company_name` varchar(25) DEFAULT '' COMMENT '所属门店名称',
  `createdate` date DEFAULT NULL COMMENT '创建时间',
  `enabled` int(5) DEFAULT NULL COMMENT '账户是否激活',
  `accountNonExpired` int(5) DEFAULT NULL COMMENT '账户是否未过期',
  `accountNonLocked` int(5) DEFAULT NULL COMMENT '账户是否未锁定',
  `credentialsNonExpired` int(5) DEFAULT NULL COMMENT '密码是否未过期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userss_id` varchar(36) NOT NULL COMMENT '用户id',
  `role_id` varchar(36) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for visit
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT 'id',
  `classification` varchar(10) DEFAULT NULL COMMENT '参访人类别（预约客户，维修人员，家属）',
  `name` varchar(32) DEFAULT NULL COMMENT '参访代表/维修人姓名',
  `tell` varchar(11) DEFAULT '' COMMENT '参访代表/维修人电话',
  `sex` varchar(2) DEFAULT '' COMMENT '参访代表/维修人性别',
  `we_chat` varchar(32) DEFAULT NULL COMMENT '微信',
  `mam_name` varchar(32) DEFAULT NULL COMMENT '被参访妈妈姓名',
  `room_id` varchar(36) DEFAULT '' COMMENT '被参访妈妈的房间号',
  `level` varchar(36) DEFAULT '' COMMENT '是否想要签约（否，是，考虑）',
  `health` varchar(36) DEFAULT '' COMMENT '健康状况（健康，异常）',
  `Temperature` varchar(36) DEFAULT '' COMMENT '体温',
  `cough` varchar(36) DEFAULT '' COMMENT '咳嗽（是，否）',
  `excepted` varchar(255) DEFAULT NULL COMMENT '异常情况（备注）',
  `in_time` datetime DEFAULT NULL COMMENT '参访时间',
  `out_time` datetime DEFAULT NULL COMMENT '离馆时间',
  `store_id` varchar(50) DEFAULT NULL COMMENT '店铺id',
  `store_name` varchar(20) DEFAULT NULL COMMENT '门店名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for worry_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `worry_evaluate`;
CREATE TABLE `worry_evaluate` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '评估Id',
  `customer_basic_id` varchar(36) DEFAULT NULL COMMENT '客户id,',
  `worry_problem_id` varchar(36) DEFAULT NULL COMMENT '忧虑id',
  `problem` varchar(255) DEFAULT '' COMMENT '问题',
  `answerone` varchar(50) DEFAULT '' COMMENT '答案A',
  `answertwo` varchar(50) DEFAULT '' COMMENT '答案B',
  `answerthree` varchar(50) DEFAULT '' COMMENT '答案C',
  `answerfour` varchar(50) DEFAULT '' COMMENT '答案D',
  `answerchoose` varchar(50) DEFAULT '' COMMENT '选择的答案',
  `evaluation` varchar(255) DEFAULT '' COMMENT '评价',
  `room_id` varchar(30) DEFAULT '' COMMENT '入住房间号id',
  `assessment_time` datetime DEFAULT NULL COMMENT '评估时间',
  `store_id` varchar(40) DEFAULT '' COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for worry_problem
-- ----------------------------
DROP TABLE IF EXISTS `worry_problem`;
CREATE TABLE `worry_problem` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '忧虑Id',
  `store_id` varchar(36) DEFAULT NULL COMMENT '门店id',
  `problem` varchar(255) DEFAULT '' COMMENT '问题',
  `answerone` varchar(50) DEFAULT '' COMMENT '答案A',
  `answertwo` varchar(50) DEFAULT NULL COMMENT '答案B',
  `answerthree` varchar(50) DEFAULT '' COMMENT '答案C',
  `answerfour` varchar(50) DEFAULT '' COMMENT '答案D',
  `answer_choose` varchar(20) DEFAULT NULL COMMENT '选择的答案',
  `evaluation` varchar(200) DEFAULT NULL COMMENT '答案对应的评价，以;隔开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for wancan
-- ----------------------------
DROP VIEW IF EXISTS `wancan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `wancan` AS select count(`nm`.`mother_menu`) AS `晚餐`,`nm`.`create_data` AS `create_data` from `nursing_meal` `nm` where `nm`.`mother_menu` = '3' group by `nm`.`create_data` ; ;

-- ----------------------------
-- View structure for wucan
-- ----------------------------
DROP VIEW IF EXISTS `wucan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `wucan` AS select count(`nm`.`mother_menu`) AS `晚餐`,`nm`.`create_data` AS `create_data` from `nursing_meal` `nm` where `nm`.`mother_menu` = '3' group by `nm`.`create_data` ; ;

-- ----------------------------
-- View structure for zaocan
-- ----------------------------
DROP VIEW IF EXISTS `zaocan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `zaocan` AS select count(`nm`.`mother_menu`) AS `早餐`,`nm`.`create_data` AS `create_data` from `nursing_meal` `nm` where `nm`.`mother_menu` = '1' group by `nm`.`create_data` ;
