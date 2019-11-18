-- MySQL dump 10.17  Distrib 10.3.16-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: animation_recommend_database
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animation`
--

DROP TABLE IF EXISTS `animation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `recommendation` text NOT NULL,
  `cover` varchar(255) NOT NULL,
  `detail` text NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `pageView` int(11) NOT NULL DEFAULT 0,
  `likeNum` int(11) NOT NULL DEFAULT 0,
  `unlikeNum` int(11) NOT NULL DEFAULT 0,
  `referrerId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `like_num` int(11) DEFAULT NULL,
  `page_view` int(11) DEFAULT NULL,
  `referrer_id` int(11) DEFAULT NULL,
  `unlike_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `referrerId` (`referrerId`),
  CONSTRAINT `animation_ibfk_1` FOREIGN KEY (`referrerId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animation`
--

LOCK TABLES `animation` WRITE;
/*!40000 ALTER TABLE `animation` DISABLE KEYS */;
INSERT INTO `animation` VALUES (1,'这个勇者明明超强却过分慎重','非常优秀的一个番剧，开创慎重流先河，是一个极少能够让我看番剧笑出来的番剧，诙谐气氛满分。\n\n首先这个番剧的画质我觉得很好，是一种带着光影效果的浮光掠影的背景，同时还有着坚实、美型的人设的番剧。\n\n第一集里面的“天界”很漂亮，美术功底扎实。\n\n然后这个人设方面也很好，慎重流的勇者是一种从来没见过的设定，而且这个番剧还把慎重这个特点给重视化了。\n\n非常好看。\n\n这个勇者，无论干什么事情都是非常的慎重，我觉得这个番剧挺适合走上社会的人观看。\n','封面图/这个勇者明明超强却过分慎重.jpg','废柴女神莉丝塔要拯救超难模式的世界，虽然成功召唤出能力值超高的勇者——圣哉，但没想到他却谨慎得过分……「我要三副盔甲，一副拿来装备，一副备用，以及备用找不到时的备用。」不仅囤积异常的库存，还自主训练到满等为止，谨慎到连打史莱姆都全力以赴！如此谨慎的勇者和被他耍得团团转的女神，即将展开冒险旅程！','https://www.bilibili.com/bangumi/media/md28222736/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.2',371,271,20,4,'2019-11-18 07:25:21','2019-11-18 07:25:21',NULL,NULL,NULL,NULL),(2,'我的英雄学院','漫威与DC的发展也促进了整个『超级英雄』题材的发展。从最开始零八年《钢铁侠》现世，到现在的《复仇者联盟三》，十年已经过去了。在这十年，甚至十年前，无数超级英雄题材的作品出现在了人们的视野中，但又有几部被铭记？一部好的英雄影片并不好做。\n\n我接触《我的英雄学院》这部作品很晚，是在一八年假期里因为无聊才去看的。说实话我开始并没有对这部作品有太大的期待。而且作为一名受到过校园欺凌的人，咔酱前期的一些行为也确实让我不适。但是，如果这真的只是一部超级英雄的番剧，也许并不会那么吸引人，毕竟有《X-Man》系列和《Avenger》系列的前辈在，即使是在日漫中也有反传统超级英雄的《一拳超人》。在我个人看来，《我的英雄学院》这部作品吸引人的地方在于体现出少年少女的成长。\n\n在这部作品中，学院里每一名下小英雄的变化都有明显的提现。绿谷少年熟练掌握了one for all，轰总解开了自己的心结，茶茶勇于突破极限，咔酱也学会了救人质而不是在战斗中一味追求炸飞对手（漫画内容）。\n\n对于人物的刻画也是这部番剧的一个亮点，咔酱就是一个很好的例子嘛（笑。很多人，包括我，都不喜欢咔酱前期的表现，弹幕里也有很多关于咔酱的争（撕）吵（逼）。但是啊，但是，受众讨论这样的问题越激烈，不就越是证明了人物塑造的饱满立体吗。只有这样才能显示出他的变化啊。\n《我的英雄学院》大概是我粉上的第二部，非漫威的超级英雄主题作品了（第一部《一拳超人》）。剧情，人物塑造，都令人满意。看完之后，我也想去当一名HERO啊啊啊！\n\n《我的英雄学院》大概是我粉上的第二部，非漫威的超级英雄主题作品了（第一部《一拳超人》）。剧情，人物塑造，都令人满意。看完之后，我也想去当一名HERO啊啊啊！','封面图/\n我的英雄学院.jpg','「架空」成为「现实」！这是一段，讲述我成为最棒的英雄的故事。一切都始于中国·轻庆市，一则「发光的婴儿」出生的新闻。自此之后，各地接连发现「超常」，但其中的原因一直没有被查明，时间就这么不断流逝。世界占总人口八成左右的人都拥有了某种「特异体质」，利用与生俱来的超常能力「个性」成为为非作歹的犯罪者。敌人不断地增多，同样拥有「个性」的另一批人则化身为「英雄」，抵挡在敌人和灾害的面前。一位少年·绿谷出久（通称臭久）也以成为英雄为目标，立志要考入诞生过众多著名英雄的雄英高中。然而，臭久他却是那剩余的两成人类中的一员，不具备任何特异体质，是一个「无个性」的吊车尾。在直面各色各样的人物以及众多试炼的过程中，臭久他为了成为了最棒的英雄...','https://www.bilibili.com/bangumi/media/md7452#detail',5740,4830,1000,4,'2019-11-18 07:25:22','2019-11-18 07:25:41',NULL,NULL,NULL,NULL),(3,'炎炎消防队','我没看过原作漫画直接看的动画，最大的印象就是登场人物的人设和性格都十分鲜明且讨人喜欢，这个很棒。原先看PV以为是单纯的超人消防员救人的故事，没想到演着演着变成了要肃清内部的内斗剧情，不过问题也不大，这种世界观如果没有一个真正的反派组织，还不如看东方110。\n\n最让我惊喜的是，虽然本作中登场的各个人物的特殊能力都是与火焰挂钩的，但却没有因为这个局限住作者的创造力，二代消防官和三代消防官能力层面的不同也为战斗增添了许多精彩的博弈（特指8队突击5队的那集）没有说我不能起火就一定打不过会起火能力的，这类似于JOJO当中的战力表现，没有垃圾的能力只有不会用能力的人。（火绳的枪斗术真的太酷了）\n\n而作为主人公的森罗，作者也给他设计了一个十分符合他英雄人设的能力，说到英雄那当然就是飞踢啊！最简单最朴实也最实用最帅，作为一个特摄厨看到这样的角色真的很开心。而一紧张就会不由自主的咧嘴笑也是一大萌点，英雄哪怕是遇到再危险的情况也要带着笑容从容应对啊！\n\n缺点方面也不是没有，看的出来动画组的资金其实不是很够，因此把大部分的资源都给到了战斗场景，而有些文戏中远景的人物则能省则省，全给你做成无脸怪了，希望日后出圆盘的时候能修正一下吧。\n\n另外一点就是，战斗方面有点太过于偏袒主角了（当然原作就是这么设定的），我个人是希望能多一点其他队员的战斗描写，让大家都有风头出。\n\n总的来说这是一部非常值得一看的动画，有点类似于英雄学院，喜欢这种题材的千万不要错过了。','封面图/炎炎消防队.jpg','全人类都在害怕着——普通人会毫无征兆地突然「燃烧」 ，变成操纵火焰的怪物「焰人」，并向周遭倾泻其极高破坏力的「人体自燃现象」 。与火焰的恐怖对抗的「特殊消防队」 ，他们的使命是解开人体自燃现象之谜并拯救人类！出于某个原因被称为「恶魔」的新入队少年?森罗，以成为「英雄」为目标，与同伴们一起，投身于与「焰人」对抗的日子中！！','https://www.bilibili.com/bangumi/media/md28221335/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.2#detail',3599,1740,430,4,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(4,'鬼灭之刃','鬼灭是一部很慢热的漫画，不过这也是大部分热血漫的缺点，如果你以前看多了火影海贼之类的，就觉绝对不会觉得剧情慢，当初的民工漫发展有多慢，心里都有数。一天的剧情就可以打上几个月，还有中间的回忆等等之类的\n\n现在的人看多了快餐番就逐渐失去了耐心，我相信现在看鬼灭觉得慢的人以前应该都是看过三大民工漫，为什么以前不觉得枯燥呢，我敢信那些人回去看民工漫一样看不下去，哪怕以前他们自己觉得多好看我觉得他们一定也很难看看的下去。\n\n鬼灭是一部温柔的漫画，也是得到了许多业界大佬肯定的漫画，连蘑菇和富坚老贼都大力捧，他们肯定比我们这些人更懂的欣赏，所以觉得发现慢的人，希望能回到以前慢慢看民工漫的时候，那时候没有进度条还不是看的津津有味，细心的评价这部漫画。','封面图/鬼灭之刃.jpg','大正时期，日本。心地善良的卖炭少年·炭治郎，有一天他的家人被鬼杀死了。而唯一幸存下来的妹妹——祢豆子变成了鬼。被绝望的现实打垮的炭治郎，为了寻找让妹妹变回人类的方法，决心朝着“鬼杀队”的道路前进。人与鬼交织的悲哀的兄妹的故事，现在开始！','https://www.bilibili.com/bangumi/media/md22718131/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.2#detail',32000,6083,508,4,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(5,'食戟之灵','食戟之灵可以说是我心目中最最好看的美食番了！\n\n作为美食番，它在美食的作画上可谓下足了心思，用足了经费，它的美食，是让我看了就流口水的。\n\n作为热血少年漫，它把决定厨师身份地位的“食戟”营造出了热血的氛围，并通过镜头的切换，bgm的应景使人完美代入其中，做到了很多战斗漫都做不到的事。\n\n我记得在其他地方看到过一个评论，说《食戟之灵》的厨师跟混黑道的一样，太夸张了吧。我倒认为，这种看似夸张的设定实则完美营造出了热血的氛围。使人入迷。\n\n紧凑的情节，出色的作画，出色的bgm，讨喜的人设，热血的氛围，只要你不讨厌卖肉（并不过分，这里的卖肉倒更像是体现食物美味的一种手段，而不是为了卖福利），那么我非常推荐补下这部食戟之灵。耐下心来看一集，你也会入坑。','封面图/食戟之灵.jpg','本作以名门料理学校“远月学园”为舞台，描绘了家里经营餐馆的幸平创真，以超越父亲城一郎为激励而日复一日地磨练自己的厨艺的故事。在初中毕业后考虑继承家业的他，却突然听闻父亲要关店数年并前往海外的消息。而后，创真在城一郎的命令下进入“远月学园”高中部就读，一部围绕着小镇上定食屋主人儿子的料理美食类故事由此开始。','https://www.bilibili.com/bangumi/media/md1559/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.2#detail',13000,6935,363,4,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(6,'罗小黑战记','刷了又刷，刷了又刷。每次罗小黑出新的一集我总要从头到尾再刷一遍，这么多遍反复地刷，我认为罗小黑这部动漫，整体上是它的风格和剧情的发展，使得很多漫人愿意去等，去期待这么一部动漫。但是它也有弊端，每一集的时长真的是让人所诟病，再加上它的更新速度，堪称“一绝”我不过多赘述，很多漫友也清楚吧，这部番从13年到现在，更新间隔越来越长，真的不知道，坚持了这么几年依然对它充满原有的热情的还有几人。加上小黑要出电影了，这部番基本处于搁置状态。我不希望，不想看到小黑因为像龙之子工作室那样的情况，栽倒在半路。说了这么多，小黑还是一部不错的动漫！','封面图/罗小黑战记.jpg','猫妖盗取天明珠被谛听发现，被打回原形重伤而逃。在流落街头的时候被罗小白带回了家，起名罗小黑。故事就这样开始了…三千元巨资打造中国动画癫疯之作。主要讲述一个少女养猫而发生的种种离奇事件，整个作品画面风格很“中国式”。故事情节搞笑、温馨别致，信息量庞大！','https://www.bilibili.com/bangumi/media/md1733/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.1',332,102,0,1,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(7,'擅长捉弄的高木同学','狗粮管饱，不说了，再去刷一遍，嘿嘿嘿~','封面图/擅长捉弄的高木同学.jpg','“今天一定要捉弄高木同学，让她害羞！”某所初中里，邻座女生高木同学总是捉弄男生西片。西片为了反过来戏弄高木同学，每天都在奋斗着……高木同学和西片的全力“捉弄”青春之战就此开始。','https://www.bilibili.com/bangumi/media/md28221403/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.1',123,32,2,1,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(8,'狐妖小红娘','很好看，停不下来的那种，剧情也很棒！这是我的入坑番我三年前入的坑，被同学安利的，那时候正在出王权篇御水珠篇和王权篇给了我极大的震撼，从那以后我入了二次元，了解到了越来越多优秀的作品，作者，声优（配音）和制作公司以及团队，如果没有这部动漫，我的视野应该还会停留在寻找优秀动画片上。','封面图/狐妖小红娘.jpg','根据古典小说记载，世上有人有妖，妖会与人相恋，妖寿命千年，人的寿命有限，人死了，妖活着。人会投胎转世，但投胎以后不记得上辈子的爱。妖如果痴情的话，就去找狐妖“购买”一项服务，让投胎转世的人回忆起前世的爱……狐妖红娘这个角色就为此而诞生。作品主要讲述了以红娘为职业的狐妖，在为前世恋人牵红线的过程中发生的一系列有趣、神秘的故事。','https://www.bilibili.com/bangumi/media/md2543/?from=search&seid=14308322059313171087',8023,4577,1,1,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(9,'犬夜叉','时隔多年再回首，犬夜叉还是这般少年，看着他们为寻四魂之玉踏上征途，从最开始的不配合到慢慢理解，相互关心，同伴也越来越多，有伤心难过，也有欢声笑语，每个人都在慢慢成长。这部番不会令你失望的！','封面图/犬夜叉.jpg','《犬夜叉》是根据日本漫画家高桥留美子所著同名作品改编的电视动画，故事讲述半妖少年——犬夜叉和穿越时空的少女——日暮戈薇，以及法师弥勒、驱魔师珊瑚、叉尾妖猫云母、小狐妖七宝一同对抗死敌奈落，并四处寻找四魂之玉碎片的冒险经历。','https://www.bilibili.com/bangumi/media/md28222083/?spm_id_from=666.25.b_6d656469615f6d6f64756c65.1',954,323,0,1,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(10,'刀剑神域','以铜为镜，可以正衣冠。以古为镜，可以知兴替。以人为镜，可以明得失。?以铜、古和人为镜，可以释放星爆气流斩。入坑就完事了。','封面图/刀剑神域.jpg','2022年，人类实现了现实世界和假想空间的融合，电子制造商开发了名为《刀剑神域（Sword Art Online）》的在线电子游戏。SAO甫一面世便大受好评，限量一万份的名额在发售当天的短时间内便被抢购一空。通过联网，玩家可以身临其境进入充满想象力和异域风情的游戏世界——浮游城市艾恩葛朗特。玩家在这里可以生活、练武、升级、经商、探险，与真实世界别无二致，却拥有无上的乐趣。曾是少数封测玩家的桐人也是这一万名幸运者中的一员。最初的兴奋过后，玩家们却发现根本无法顺利登出游戏，更为恐怖的是，一旦玩家的HP归零，现实世界中他们的肉体也将死亡。他们被SAO的开发者茅场晶彦困在游戏中，顺利逃脱的方法似乎只有一个，那就是完成困难重重的攻略任务……','',723,512,2,1,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(11,'网球王子','每一个角色都喜欢，每个情节都热爱，每个人的名字都记得比初高中同学更清楚。虽然它已经是连tv更新都没有消息的老漫，作者也忙于唱歌和一部新漫画而渐渐敷衍，但是每次重温的时候，还是会被感染: 青春，阳光，热血。那并不是一个没有阴霾的世界，但是有一群心中没有阴霾的少年，感染着所有的观众。','封面图/网球王子.jpg','新学期开始，青春学院实力强劲的网球部的来了一个初一新生——越前龙马。虽然帮助网球部其他新生出头不被高年级欺负，不过他的态度真是跩的可以，于是很快就和前辈用比赛决胜负。出人意料的是他的实力也确实高的惊人，引起了网球部指导老师和社长手冢的注意，并破例将他选入正式队员队伍，开始了通往全国大赛的征途……其实龙马的父亲越前南次郎也曾是在世界网坛昙花一现的职网球员，在美国打败所有职业网球高手赢得冠军，却因不明原因退出网坛，归隐在日本一家寺院。龙马从小在父亲近乎捉弄的态度下学习网球，对他来说网球并不是爱好，而是打败父亲的目标，因此在他心中有一个难以超越的背影。在和队友、对手的比赛交流中，龙马渐渐看清了一个更有意义的目标——全国大赛...','https://www.bilibili.com/bangumi/media/md5281/?from=search&seid=9502326846230115839#detail',6320,1532,5,6,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(12,'未来少年柯南','来来回回看了不下十遍，和太阳王子、天空之城联系都很大','封面图/未来少年柯南.jpg','日本动画大师宫崎骏作品。西历2008年7月，因科学过度发展，威力强大的超磁力武器，在战争中被发动，地轴弯曲，地壳发生大变动，五大洲爆裂，陆地下沉，在一瞬间把一半的地球摧毁！ 20年后，在残留的小岛上，一直以为在大变动后世上只余下他与爷爷相依为命的少年高立，在偶然间，在岛上海滩救了有与动物沟通能力的少女罗拉，因为罗拉的爷爷是科学家，所以野心家们便想捕捉罗拉对其作出威胁。来到岛上的坏人杀害了高立的爷爷，并捉走了罗拉，因此高立便踏上了拯救罗拉的旅程。','https://www.bilibili.com/bangumi/media/md2464/?from=search&seid=289260489602996452',500,100,1,6,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(13,'超元气三姐妹','额(-ι_- )……，抱歉！其实标题应该是《污力十足，元气番。日常怪笑，为井（丸井）三（姊妹）》。元气十足的三姊妹，各赋性格的同学和家长以及老师们。夸大他们的兴趣，爱好及性格，让他们的脑洞造成，毁天灭地的效果（误）。（我是一路笑到尾的）','封面图/超元气三姐妹.jpg','《超元气三姐妹》是桜井のりお从2006年起连载于秋田书店《周刊少年Champion》上的搞笑萌系漫画，目前尚在连载中，单行本已发售至11卷。《超元气3姐妹》和先前两部“三姐妹”的不同之处在于，本作中三姐妹的年龄相同，都是含苞待放的小学六年级生（还是思想邪恶的），而不是如那两部作品那样相差数年。 《超元气三姐妹》中的丸井三姐妹虽然是三胞胎，但是她们不只长得不像，连个性也完全不同，可以说她们是全日本长得最不像的三胞胎。','https://www.bilibili.com/bangumi/media/md949/?from=search&seid=14061822939852141160',450,123,54,6,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(14,'某科学的超电磁炮S','在看超炮S的时候，总是会出现一堆“生怕别人不知道自己学过高中物理”的弹幕，比如“电流是标量怎么能反弹！”“温度是标量所以初春能秒一方！”之类的。更有甚者实在让人怀疑弹幕作者连高中也没上过，“时间有方向所以应该是矢量”“向量是向量，不能算矢量”，诸如此类。','封面图/某科学的超电磁炮S.jpg','《科学超电磁炮（とある科学の超电磁炮）》是以镰池和马所著作的轻小说《魔法禁书目录》的人气角色御坂美琴为主角所作的外传漫画，由冬川基作画，连载于月刊Comic电击大王，至2009年12月已经累计销售180万部。2009年10月改编为电视动画，共25集（24集+番外篇1集），由J.C.STAFF制作。','https://www.bilibili.com/bangumi/media/md427/?from=search&seid=15122634942905200019#long',320,35,12,6,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(15,'超时空要塞 Macross','永远的经典，永远的麦克洛斯号，一条辉、早濑未沙、林明美，还有那么多麦克洛斯舰上有名的、无名的英雄们。','封面图/超时空要塞 Macross.jpg','西历2067年，新的故事即将上演。银河系边境行星的中心、失去自我而狂暴化的“Bajura”症候群扩大化。眼见事态严重，星间复合企业体为控制症状，以少女们的“战术音乐组合walküre”与共同作战的“Valkyrie部队”一起集结。另一方面，“风之王国”被称为“空中骑士团”的“谜之Valkyrie部队”开始有所动作。“普罗多卡迪的遗产”引人思考的问号中、越过星辰，热烈的爱与友情的故事扬起了帷幕。','https://www.bilibili.com/bangumi/media/md1187/?from=search&seid=16593845894710338195#short',462,23,2,6,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(16,'星合之空','如果瞬间要说出十个只要听到就会心潮澎湃的词汇，你会选择哪些？\n\n我的话一定是：少年，青春，相遇，友情，宇宙，恒星，春风，信任，勇气，以及奇迹。\n\n而这些词汇集起来又会带来全世界最美妙的单词：“惊喜”。\n\n—《星合之空》，正是我在这个好作品频出的梦幻十月相遇到的最大的惊喜。\n\n\n\n事实上，我对星合最初的印象来自新番列表上的惊鸿一瞥。只需要一眼，漂亮意味不明的名字和清新的画风就一起抓住了我的眼睛，点开pv，又被动人的配乐给抓住了耳朵。等到月中番剧好不容易更新，他便用流畅的作画，别致的人设，有趣的展开，勇敢的视角，真实的触感准确俘获了我的红心。\n\n然而第一话的舆论中，很多观众都对这份真实的触感颇有微词。\n\n星合清新的画风与营造得颇具透明感的气氛将故事装点得像个童话，似乎只有男孩们聚在一起进行一些软乎乎，令人愉悦的社团与友情活动。一切看起来都该是无限美好和睦。童话世界远离所有尖锐同矛盾。可是作为监督的赤根老师不想只是描绘美好的梦境。\n\n他在访谈里说星合要描绘的就是格格不入的主角，现实中常出现的所谓“人生的输家”，因为年纪尚幼无法逃离，长大后就会遗忘的种种伤痛。这些伤痛确实存在于我们的生活中，或许与一些人面碰面撞出过满头血，或许活在阴影里成为一趟又一趟，“幸存者”们的谈资。\n\n伤痛无一例外。都令人恐惧。\n\n遭遇过的人则会产生包含恐惧在内的更加复杂的心绪。没有经历过同样的处境，根本无法去谈互相理解，感同身受。\n\n这可能是许多人看过第一话后对作品排斥的原因。童话一般的梦幻表皮下，赤根监督决定描写所有他所见的真实。囊括真实世界的黑白两面：活泼的少年少女，消极的少年少女，打磨青春的勇者，虚度青春的游徒。这个世界就是允许这样的不同同时存在。这个世界就是存在不爱子女的父母、通过欺凌获取价值的蠢货，等等等等，还有更多。\n\n看见他们在社会新闻中出现我们可能会愤然一句天呐，一边感叹世界的不合理，一边寻找抨击这些错误出现的源头。\n\n看见他们在轻飘飘的动画中出现又会怎么样呢？\n\n许多人对此表示了不适。\n\n但就我而言，动画同样是承载价值观的重要创作产物。不单可以用于消遣打发时间，释放幻想。他可以一边漂亮可爱，一边用甜美的语言把阴影和伤痛摊开在我面前。这是动画天然具有的资格。\n\n而为什么我偏偏选择接受甚至是热爱星合之空表现真实的方式。则是因为：\n\n他想做的不只是勇敢地展现伤口，还有温柔的治愈。把美好的东西打破给人看可以造就最难过的悲剧，直视伤痛治愈伤痛则会成就最圆满的Happyending。\n\n我期待星合之空到达类似的Happyending。赤根监督在作品和访谈中体现出的对少年人的祝福无一不使我深深动容。以及深深信任星合之空真的能成为一部，制作用心，故事动人，主题积极，略显不合时宜，但确实能留下什么的好作品。\n\n这三集中体现的人物塑造，故事节奏，表现力度也足够支撑起我的信任。\n\n小少年们于伤痛之上追逐微风，迎着蔚蓝的天空跨过条条框框，“保持着自己的尊严和个性生活下去”。不再害怕，不要遗忘，不再孤独，不必赢得胜利，只要坦荡又努力地生活下去。这就是我在见过真实之后，所想象出的梦境。\n\n为了等到梦境实现，这次我绝不移开视线。','封面图/星合之空.jpg','以即将废部的男子中学软式网球部为舞台，讲述了抱着各自想法的少年们讴歌青春的故事。','https://www.bilibili.com/bangumi/media/md28222738',1233,132,23,3,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(17,'刺客伍六七','《刺客伍六七》的剧情相当引人入胜，细思极恐，全是细节，相当多的暗示表明一切的背后有着更大的故事，有着无厘头的搞笑又不乏深刻的道理，制作组在两者之间找到了一个均衡点，剧情几乎完美的安排使得动漫中每个人的形象都生动鲜明。','封面图/刺客伍六七.jpg','在某个小岛上，有一个可以伪装成任何东西的廉价刺客，名叫伍六七。平时看上去是个理发师，其实背地里却做着刺客生意。热爱理发事业，喜欢给人剪头发，善用剪刀——剪刀也是他的刺杀武器。由于初入刺客行当，行情十分廉价，因此接到的都是些奇葩的刺杀任务。在执行刺杀任务的过程中，与刺杀对象发生一系列有趣的意外事件。','https://www.bilibili.com/bangumi/media/md6360',11111,356,12,3,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(18,'BEASTARS','这是一场动物版的青春人性剧。\\n在《BEASTARS》的架空世界中，肉食动物与草食动物皆具备高度智能，和谐共处。受制于社会道德的约束以及公共规则的需要，食肉等同于杀人一般的重罪，而男主灰狼雷格西所处的全寄宿制的名门高中却里顿学园发生了学生被吞噬的“食杀事件”；不安的情绪与被抑制的兽性在空气中弥漫开来，我们的故事也由此缓缓拉开了帷幕。','封面图/BEASTARS.jpg','肉食兽和草食兽共存的世界。在食肉被视为重罪的情况下 ，全寄宿制的名门高中·却里顿学园发生了学生被吞噬的“食杀事件”。在充斥着不安的校园里，戏剧部的怪人·灰狼雷格西过着与其“庞大身躯”和“锐利尖牙”相反的安静生活。但是和小巧的兔子的女学生·春的相遇，打动了雷格西的心。“我追求她的心情，是恋爱？还是食欲？”他真正遇到的东西，是他自己的本能——','https://www.bilibili.com/bangumi/media/md28222618',2344,1200,21,3,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(19,'怪诞小镇','暑假到了，双胞胎姐弟俩梅宝（克里斯汀·沙尔 Kristen Schaal 配音）和迪普（杰森·雷特 Jason Ritter 配音）被爸妈赶到一个偏僻小镇“重力泉”过暑假，在这里，他们的斯坦叔公经营着一家专门敲诈游客的旅游景点“神秘小屋”，其中有着各种各样稀奇古怪的东西。然而更让人感到毛骨悚然的，则是这个怪诞小镇里的森林。为人慎重、头脑聪明的迪普觉察到森林的异样，继而发现了一本埋在地下的神秘笔记本，里面记载着存在于神秘小镇的不为人知的秘密。乐天派的梅宝和机智的迪普，结识了神秘小屋的店员温蒂和苏斯，还遇到各种奇妙的小镇居民。在怪诞小镇重力泉，他们经历了一系列奇异事件，小矮人，湖怪，蜡像，通灵者，他们这个暑假注定不平凡。','封面图/怪诞小镇.jpg','12岁的迪普和双胞胎姐姐梅宝被从加州的家中送到了一个虚构的俄勒冈小镇——重力泉镇，与住在那里，经营着满是欺骗游客陷阱的“神秘小屋”的斯坦叔公一同度过暑假。\n这个小镇并不像看上去的那样祥和平静，孩子们一边帮助斯坦经营满是欺骗游客陷阱的“神秘小屋（The Mystery Shack）”，一边调查当地神秘事件。在迪普从森林里发现的日志的帮助下，姐弟俩开始慢慢的解开这个小镇的种种谜团。随着迪普和梅宝的好朋友：收银员温蒂、勤杂工苏斯，以及各种角色的出现，让迪普和梅宝总能对新的一天充满期待。','',21223,235,123,3,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(20,'灵笼','优点画面画质非常好，配乐也超赞，比同类作品高出一大截。\\n缺点是里面英雄豪杰重要人物基本上都是欧美面孔，为数不多的亚洲人种都是女性，配给了诸位欧美英雄豪杰高官显贵。主角霍夫曼有冉冰，城主摩根和镜南配戏，教会金发也有个前凸后翘的樊缔。希望人类共同体里人种能再平衡一些。当然，也许剧情峰回路转，这样人种安排是有剧情需要，比如基因筛选之类的策略再做妖，算我没说。','封面图/灵笼.jpg','不久的未来，人类的世界早已拥挤不堪，迈向星河、寻找新家园的行动迫在眉捷。正当一切有条不紊的推进之时，月相异动，脚下的大地爆发了长达数十年、剧烈的地质变化，人类在这场浩劫中所剩无几。当天地逐渐恢复平静，人们从废墟和深渊中重新踏上了这片熟悉而又陌生的大地。习惯了主宰一切的我们是否还是这个世界的主人？','https://www.bilibili.com/bangumi/media/md23432',12123,535,123,3,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(21,'青春猪头少年不会梦到兔女郎学姐','如果提前了解了你们要面对的人生，不知道你们是否还会有勇气去面对，看见的和听到的，往往会让你们沮丧甚至受伤，世俗就是这样强大。强大到生不出改变他们的念头来。\n但是如果提前了解了你们的人生，知道青春也无非只有这些日子，不知道你们是否还会去在意那些世俗希望你们在意的东西。等你们长大，你们会因绿芽冒出土地而喜悦，会对初生的朝阳欢呼跳跃，也会给别人善意和温暖。但是也会在赞美别的生命的同时，常常，甚至永远忽略了自己的珍贵。\n愿你在被打击时，记起你的珍贵，抵抗恶意。愿你在迷茫时，坚信你的珍贵，爱你所爱，行你所行，听从你心，无问西东。\n多谢陪伴，青春永不完结。','封面图/青春猪头少年不会梦到兔女郎学姐.jpg','青春期症候群——这是一种只发生在易敏感和不稳定的青春期的、不可思议的现象。例如，在梓川咲太面前出现的野生兔女郎。她的真实身份是高中高年级学生，明星活动休止的女演员樱岛麻衣。她迷人的身姿，不知为何在周围的人眼里看不出来。咲太决定解开这一谜题。在与麻衣一起度过的时间里，咲太知道了她秘密的想法……女主人公们一个接一个地出现在咲太的周围，她们都有着“青春期症候群”。在天空和大海都很闪耀的小镇上，开始了令人激动的故事。','https://www.bilibili.com/bangumi/play/ss25733',2333,1522,0,5,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(22,'工作细胞','在一个人的身体中，约有60兆个细胞，每种细胞都有各自的任务……冒失又慌张新人红血球小姐，在她差点被肺炎链球菌袭击时遇到了冷酷的白血球先生。白血球不仅在她差点被肺炎链球菌袭击时，救了她一命，还顺道帮她带路到肺部……当遇到擦伤时，就需要可爱的血小板妹妹帮忙让伤口愈合……本番将细胞及病菌拟人化，以深入浅出的方式介绍人体细胞的功能！','封面图/工作细胞.jpg','这是一个关于你自身的故事。你体内的故事——。人的细胞数量，约为37兆2千亿个。细胞们在名为身体的世界中，今天也精神满满、无休无眠地在工作着。运送着氧气的红细胞，与细菌战斗的白细胞……！这里，有着细胞们不为人知的故事。','https://www.bilibili.com/bangumi/play/ss24588/',285,251,0,5,'2019-11-18 07:25:22','2019-11-18 07:25:22',NULL,NULL,NULL,NULL),(23,'此花亭奇谭','感觉此花绮谭的精彩之处就在于它能把那些简单却又容易被忽略的哲理磨成粉，在加入感情之泉熬成汤，最后再经由剧中角色之手喂到你的嘴边。所以即便作为载具的器皿（故事的套路）看上去并没有什么特别之处，但碗内的料理（制作者的诚意）却是分量十足。\n如薄雾般飘散着的是名为百合的芳香、入口即化的是包着萌要素的棉花糖、世界观与作者的思想一并融在汤里，推荐的“用餐方式”是静下心来一小口一小口的细细品尝。毕竟比起“美味”这番给人更多的感受是“治愈与温馨”。','封面图/此花亭奇谭.jpg','侍奉神明的狐娘们工作的温泉旅馆“此花亭”。“此花绮谭”便是来此花葶服务的新人服务员柚，和围绕着柚的伙伴们的暖人心怀的故事。服务员们想法只有一个。“不论真实身份是什么，不论是何等样人，客人就是神。”当然，现在在眼前的你也是……请接触柚她们的“招待”，来治愈疲惫的心吧。','https://www.bilibili.com/bangumi/play/ss6425/',335,334,0,5,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(24,'我，不是说了能力要平均值么！','我是project No.9的社长，又是无聊的周一。我看了看我的劳力士，又到了找理由扣经费的时间。打算去看看这个月的画师工作得怎么样。上周《平均值》的画师的插画一份都没派发走，还把超人高中生的插画给烧掉。本想把他调到非洲，为非洲动漫事业继续服务，但一想到，为了节约经费，他连女主角的胸都画得很小，在连电都没有的地方怎么迎合非洲部落的审美，就又起了富人之仁。突然想起了之前在B站看到两部番剧的评分，我就起了探究真理的想法。想看看，是不是B站的评分和动漫的经费成反比例关系。于是我当着两个画师的面，把《平均值》一半的经费，拨给了《超人高中生》。看着他愤愤不平的表情被多年摸爬滚打的经历磨成了淡然笑笑，还有他身旁人眼里对他的炫耀和不屑，我感觉特别好玩。唉，有钱人的周一，就是这么朴实无华～～且枯燥。','封面图/我，不是说了能力要平均值么！.jpg','在剑与魔法的异世界舞台，描绘少女们友情与成长的平均值？冒险就此展开。','https://www.bilibili.com/bangumi/play/ss28544/',360,248,0,5,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(25,'某科学的一方通行','《某科学的一方通行》（?）\n《不科学的角色塑造》（?）\n《某作死的自大反派》（?）\n《某魔改的一方通行》（?）\n《某科学的风光下葬》（?)','封面图/某科学的一方通行.jpg','位于东京西部的巨大“学园都市”。 在总人口达230万人，其中约8成是学生的这座都市中，实施着超能力开发的特殊课程，学生们的能力被给予从“无能力Level 0”到“超能力Level 5”的六阶段评价。 在这样的学园都市君临能力者顶点的最强能力者·一方通行。他在仅有7人的“超能力者”当中也以远超其他人的能力位居第一。不断重复、脱离常轨的“实验”，以及在追求绝对力量的最后品尝到的败北。在那之后，随着与一位少女——最后之作的相遇，他的命运产生了巨大变化。 最强而最凶的“恶”——一方通行， 扫平学园都市的“黑暗”!!','https://www.bilibili.com/bangumi/play/ss28002/',555,520,0,5,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(26,'斗罗大陆','等了一年多 总算动漫化了，品质特别棒，难怪斗破要换制作方了。而且，吃狗粮不生气哈哈哈哈哈。','封面图/斗罗大陆.jpg','唐门外门弟子唐三，因偷学内门绝学为唐门所不容，跳崖明志时却发现没有死，反而以另外一个身份来到了另一个世界，一个属于武魂的世界，名叫斗罗大陆。这里没有魔法，没有斗气，没有武术，却有神奇的武魂。这里的每个人，在自己六岁的时候，都会在武魂殿中令武魂觉醒。武魂有动物，有植物，有器物，武魂可以辅助人们的日常生活。而其中一些特别出色的武魂却可以用来修炼并进行战斗，这个职业，是斗罗大陆上最为强大也是最荣耀的职业“魂师”。 小小的唐三在圣魂村开始了他的魂师修炼之路，并萌生了振兴唐门的梦想。当唐门暗器来到斗罗大陆，当唐三武魂觉醒，他能否在这片武魂的世界再铸唐门的辉煌？','https://v.qq.com/x/cover/m441e3rjq9kwpsc.htmll',20000,5000,10,2,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(27,'书灵记','国漫必须支持支持支持！重要的说三遍。','封面图/书灵记.jpg','瀛洲界内，诸子百家，唐诗宋词，皆有书灵。在《唐诗三百首》中醒来的书灵顾七绝，骑着《山海经》的神兽驳， 与为了养活自己和一群妹子而努力奋斗的乐五音一起踏上了一条寻找唤醒其他书灵的道路。','https://v.qq.com/x/cover/mzc00200b1plp0l.html',1000,50,500,2,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(28,'一人之下','时长应该说是国产动漫中最长的吧。所以很满足，必须支持。而且四川话加分哈哈哈哈哈哈。','封面图/一人之下.jpg','这个世界是存在异人的。刚刚接触异人世界的张楚岚，加入了管理异人的组织“哪都通”。为了解开爷爷和自身的秘密，张楚岚和冯宝宝一起前往龙虎山天师府参加异人界的盛会——罗天大醮，并与众多异人高手对战。','https://v.qq.com/x/cover/3enwc74hj562xjd/m0568miozpj.html',5000,1000,50,2,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(29,'黑猫警长','动漫化的动物世界里，要说被塑造形象及个性最丰富的物种，应该是非“猫”莫属了。美国有慵懒搞怪的加菲猫，日本有八宝哆啦A梦+可爱教主 HelloKitty ，我们也有当之无愧的中国第一“猫”——《黑猫警长》。能位居榜首，自然有不可替代的强势理由。此剧仅凭 5 集的内容便在电视荧屏上纵横了25年并经久不衰；图书市场上，时至今日，父母为子女选购的第一批卡通读物也必然有它的身影。','封面图/黑猫警长.jpg','中国经典动画-黑猫警长，陪伴童年的超喜欢的国产动画！ 不足100分钟的总片长，捧红了三个“腕儿”，英姿飒爽的黑猫警长，壮烈牺牲的白猫班长以及笨笨的坏蛋“一只耳”。当年被指带点“洋”味的旧作已征服了观众和社会。','https://v.qq.com/x/cover/ax6cm81c0gcsqs2.html',10000,7000,5,2,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL),(30,'一禅小和尚','短，但句句经典。超喜欢。','封面图/一禅小和尚.jpg','小和尚一禅和师父的日常生活。观众能够从中领悟人生的道理，体会身处尘世的芸芸众生的喜怒哀乐、怨憎会、爱别离与求不得。','https://v.qq.com/x/cover/ij4yjidgfnw346d/w0357ptsfjx.html',999,88,54,2,'2019-11-18 07:25:23','2019-11-18 07:25:23',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `animation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animation_type`
--

DROP TABLE IF EXISTS `animation_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animation_type` (
  `animationID` int(11) NOT NULL,
  `typeID` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`animationID`,`typeID`),
  KEY `typeID` (`typeID`),
  CONSTRAINT `animation_type_ibfk_1` FOREIGN KEY (`animationID`) REFERENCES `animation` (`id`),
  CONSTRAINT `animation_type_ibfk_2` FOREIGN KEY (`typeID`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animation_type`
--

LOCK TABLES `animation_type` WRITE;
/*!40000 ALTER TABLE `animation_type` DISABLE KEYS */;
INSERT INTO `animation_type` VALUES (1,4,'2019-11-18 07:29:50','2019-11-18 07:29:50'),(2,1,'2019-11-18 07:29:50','2019-11-18 07:29:50'),(2,7,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(3,1,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(3,3,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(4,1,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(5,1,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(5,7,'2019-11-18 07:29:51','2019-11-18 07:29:51'),(6,6,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(7,7,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(8,6,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(9,1,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(10,3,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(11,9,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(12,1,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(12,3,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(13,4,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(13,6,'2019-11-18 07:29:52','2019-11-18 07:29:52'),(14,7,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(15,3,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(16,9,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(17,4,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(18,1,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(19,10,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(20,3,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(21,6,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(21,7,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(21,11,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(22,12,'2019-11-18 07:29:53','2019-11-18 07:29:53'),(23,6,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(24,4,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(25,13,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(26,1,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(26,3,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(27,3,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(28,1,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(28,4,'2019-11-18 07:29:54','2019-11-18 07:29:54'),(30,6,'2019-11-18 07:29:54','2019-11-18 07:29:54');
/*!40000 ALTER TABLE `animation_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attitude`
--

DROP TABLE IF EXISTS `attitude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attitude` (
  `userID` int(11) NOT NULL,
  `animationID` int(11) NOT NULL,
  `favorite` tinyint(1) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`userID`,`animationID`),
  KEY `animationID` (`animationID`),
  CONSTRAINT `attitude_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `attitude_ibfk_2` FOREIGN KEY (`animationID`) REFERENCES `animation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attitude`
--

LOCK TABLES `attitude` WRITE;
/*!40000 ALTER TABLE `attitude` DISABLE KEYS */;
/*!40000 ALTER TABLE `attitude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `userID` int(11) NOT NULL,
  `animationID` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`,`animationID`,`comment`),
  KEY `animationID` (`animationID`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`animationID`) REFERENCES `animation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'热血','2019-11-18 06:32:39','2019-11-18 06:32:39'),(2,'穿越','2019-11-18 06:32:39','2019-11-18 06:32:39'),(3,'科幻','2019-11-18 06:32:39','2019-11-18 06:32:39'),(4,'搞笑','2019-11-18 06:32:39','2019-11-18 06:32:39'),(5,'泡面','2019-11-18 06:32:39','2019-11-18 06:32:39'),(6,'治愈','2019-11-18 06:32:39','2019-11-18 06:32:39'),(7,'校园','2019-11-18 06:32:39','2019-11-18 06:32:39'),(8,'历史','2019-11-18 06:32:39','2019-11-18 06:32:39'),(9,'青春','2019-11-18 06:44:48','2019-11-18 06:44:48'),(10,'剧情','2019-11-18 06:44:48','2019-11-18 06:44:48'),(11,'恋爱','2019-11-18 06:44:48','2019-11-18 06:44:48'),(12,'科普','2019-11-18 06:44:48','2019-11-18 06:44:48'),(13,'战斗','2019-11-18 06:44:48','2019-11-18 06:44:48');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dream','123456','cjj','2019-11-18 05:29:59','2019-11-18 05:29:59'),(2,'如迢','123456','hxm','2019-11-18 05:30:29','2019-11-18 05:30:29'),(3,'killMyTIme','123456','lwj','2019-11-18 05:31:02','2019-11-18 05:31:02'),(4,'joker','123456','lxm','2019-11-18 05:31:22','2019-11-18 05:31:22'),(5,'nerd','123456','whh','2019-11-18 05:31:47','2019-11-18 05:31:47'),(6,'bear','123456','xlh','2019-11-18 05:33:13','2019-11-18 05:33:13');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `userID` int(11) NOT NULL,
  `typeID` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateTime` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`userID`,`typeID`),
  KEY `typeID` (`typeID`),
  CONSTRAINT `user_type_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  CONSTRAINT `user_type_ibfk_2` FOREIGN KEY (`typeID`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-18 22:12:04
