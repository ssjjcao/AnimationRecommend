## _Animation Recommend Database Design_
### _version 6.0_

### _Table Name_
  * [_User_](#User)
  * [_Animation_](#Animation)
  * [_Type_](#Type)
  * [_Animation_Type_](#Animation_Type)
  * [_User_Type_](#User_Type)
  * [_Attitude_](#Attitude)
  * [_Comments_](#Comments)
 
### <span id="User">_user_</span>

| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name | 用户名 | String | name可以唯一映射一个用户，不允许出现重复用户名 |
| password | 密码 | String |
| signature | 个性签名 | String |
| createTime | 创建时间 | timestamp | 方便数据库维护 |
| updateTime | 更新时间 | timestamp | 方便数据库维护 |

### <span id="Animation">_Animation_</span>

| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name| 番剧名 | String | name可以唯一映射一部番剧，不允许出现重复番剧名 |
| recommendation | 推荐语 | String |
| cover |封面图 | String |
| detail| 详情 | String |
| link | 观看链接 | String |
| pageView| 浏览量 | Integer |
| likeNum | 点赞数 | Integer |
| unlikeNum | 点踩数 | Integer |
| referrerID | 推荐人 | Integer |
| createTime | 创建时间 | timestamp | 方便数据库维护 |
| updateTime | 更新时间 | timestamp | 方便数据库维护 |

### <span id="Type">_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name | 番剧类型 | String |
| createTime | 创建时间 | timestamp |
| updateTime | 更新时间 | timestamp |

### <span id="Animation_Type">_Animation_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| animationID | 番剧id | Integer |
| typeID | 番剧类型id | Integer |
| createTime | 创建时间 | timestamp |
| updateTime | 更新时间 | timestamp |

### <span id="User_Type">_User_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| typeID | 番剧类型id | Integer |
| createTime | 创建时间 | timestamp |
| updateTime | 更新时间 | timestamp |

### <span id="Attitude">_Attitude_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| animationID | 番剧id | Integer |
| favorite | true or false or null 表示是否喜欢 | Boolean |
| createTime | 创建时间 | timestamp |
| updateTime | 更新时间 | timestamp |

### <span id="Comments">_Comments_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| animationID | 番剧id | Integer |
| comment | 评论 | String |
| createTime | 创建时间 | timestamp |
| updateTime | 更新时间 | timestamp |
