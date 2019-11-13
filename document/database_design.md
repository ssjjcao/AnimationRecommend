##_Animation Recommend Database Design_
###_version 3.0_

###_Table Name_
 * ####[_User_](#User)
 * ####[_Animation_](#Animation)
 * ####[_Type_](#Type)
 * ####[_AnimationConnectType_](#AnimationConnectType)
 * ####[_UserConnectType_](#UserConnectType)
 * ####[_UserAttitudeToAnimation_](#UserAttitudeToAnimation)
 * ####[_UserCommentAnimation_](#UserCommentAnimation)
 
###<span id="User">_user_</span>
| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name | 用户名 | String | name可以唯一映射一个用户，不允许出现重复用户名 |
| email | 邮件 | String | email可以唯一映射一个用户，不允许出现重复email |
| password | 密码 | String |
| signature | 个性签名 | String |

###<span id="Animation">_Animation_</span>

| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name| 番剧名 | String | name可以唯一映射一部番剧，不允许出现重复番剧名 |
| recommendation | 推荐语 | String |
| cover |封面图 | String |
| detail| 详情 | String |
| pageView| 浏览量 | Integer |
| likeNum | 点赞数 | Integer |
| unlikeNum | 点踩数 | Integer |
| referrer | 推荐人 | String |

###<span id="Type">_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
|id | 伪主键 | Integer |
|name | 番剧类型 | String |

###<span id="AnimationConnectType">_AnimationConnectType_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| animationID | 番剧id | Integer |
| typeID | 番剧类型id | Integer |

###<span id="UserConnectType">_UserConnectType_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| typeID | 番剧类型id | Integer |

###<span id="UserAttitudeToAnimation">_UserAttitudeToAnimation_</span>


| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| animationID | 番剧id | Integer |
| favorite | true or false or null 表示是否喜欢 | Boolean |

###<span id="UserCommentAnimation">_UserCommentAnimation_</span>
| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| userID | 用户id | Integer |
| animationID | 番剧id | Integer |
| comment | 评论 | String |
