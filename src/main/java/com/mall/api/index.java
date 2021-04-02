package com.mall.api;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/**
 * @Author
 * @Date 2020-08-12 22:01
 */
public class index extends Controller {

    @Clear
    public void index(){
        renderHtml("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Title</title><style>*{padding:0;margin:0}.box_content{height:100vh;display:flex;align-items:center;justify-content:center;box-sizing:border-box}.box{display:flex;flex-direction:column;align-items:center;color:#333}.box p{margin-top:30px}.box img{width:150px;height:150px}.bottom{position:absolute;bottom:60px;left:50%;transform:translateX(-50%);color:#999}.bottom.telphone{bottom:100px;display:flex;align-items:center;color:#555}.bottom.link:hover{color:#298DF8;text-decoration:underline}.tel-icon{display:flex;align-items:center;margin-right:10px}.tel-icon img{width:20px;height:20px}</style></head><body><div class='box_content'><div class='box'><img src='https://www.ringsomeone.com/upload/WechatIMG7.PNG'alt=''><p style='font-size: 36px;font-weight: 700'>铃之</p><p style='font-size: 20px'>一款社交化时间效率管理工具</p></div><p style='font-size: 16px;'class='bottom telphone'><span class='tel-icon'><img src='https://www.ringsomeone.com/upload/telphone.png'alt=''></span>服务热线:400-008-0620</p><p style='font-size: 16px;cursor: pointer'class='bottom link'id='url-link'><a href='https://beian.miit.gov.cn/'>@copyright 2020粤ICP备20009192号-2</a></p></div><script>window.addEventListener('load',function(ev){let link=document.getElementById('url-link')link.addEventListener('click',function(e){window.open('https://beian.miit.gov.cn/')})})</script></body></html>");
    }
    @Clear
    public void protocols() {
        renderHtml("<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'><title>用户协议和隐私政策</title><style>        html,body,div,header,main,article,footer,section,aside,nav,hgroup,ul,li,h1,h2,h3,h4,dl,dt,dd,p,a,span,i,em,img,input,textarea { margin:0; padding:0;}        header,main,article,footer,section,aside,nav {display: block;}          html,body { font-family:'Microsoft yahei', Helvetica, Arial, sans-serif; font-size:14px;}        h1,h2,h3,h4,h5{font-weight:normal;}          a,img,input{ border:none 0; text-decoration:none;outline:none; }        a:hover { text-decoration:none; }        a:focus,input:focus { outline:0 none;}         li { list-style:none; }        i,em,cite { font-style:normal;}        a { text-decoration:none; outline:none; -webkit-tap-highlight-color:rgba(0,0,0,0); }        a.css-cursor-auto{cursor:auto;color:#00a2ff !important;}        a.css-bracketing{cursor:auto;color:#00a2ff !important;}        span{-webkit-tap-highlight-color:rgba(0,0,0,0);}        input,textarea,li,a{-webkit-tap-highlight-color:rgba(0,0,0,0); }        textarea { resize:none; font-size:12px;outline: none 0;border:none 0; }         textarea ,input ,button{-webkit-appearance: none;}        button{text-align:center;background:#fff;border:0;outline:0;}        input[type='text']{border:1px solid #ddd;height:40px;text-indent:7px;}        input[type='checkbox']{-webkit-appearance:checkbox;}        input[type='radio']{-webkit-appearance:radio;};        select{height:40px;}        input::-webkit-input-placeholder,textarea::-webkit-input-placeholder{color:#ddd;font-size:12px;}        .none{display: none;}        .pos-rel{position: relative;}                .css-bg{            width: 100%;        }        .css-a,.css-b{            position: absolute;            top:76.923%;            left:0%;            display: block;            width: 100%;            height:4.1%;            background-color: transparent;            font-size:0;        }        .css-b{            top:83.544%;        }        .text-center{text-align: center;}        .css-body{color:#333;padding:10px;}        .css-body h3{font-size:16px;text-align: center;margin-top: 10px;}        .css-body h5{font-size:14px;margin:10px auto;}        .css-body p{font-size:12px;text-indent:2em;}        .fontBold {            font-weight:600;        }</style></head><body class='css-body pos-rel'><h3 class='fontBold'>用户注册及使用协议</h3><h5 class='text-center fontBold'>一、总则</h5><p>1、用户在注册和使用深圳市机智网路科技有限公司（下称“机智科技”）提供的“铃之”服务之前（下称“服务”），应仔细阅读本协议。<span class='fontBold'>用户同意本协议的全部条款并按照页面上的提示完成全部注册程序后，即表示用户已与机智科技达成协议，用户完全接受本协议项下的全部条款，受本协议条款的约束。</span>    2、如不同意本协议的，用户可以主动停止注册或停止使用本服务；用户一旦使用本服务，即视为已了解并完全同意本协议各项内容，包括机智科技对服务协议随时所做的任何修改。    3、机智科技有权随时根据中华人民共和国的有关法律、法规的变化以及公司经营状况和经营策略的调整等对本协议进行修改，而无需另行单独通知用户。修改后的协议会在此及时更新。更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，用户可在此查阅最新协议条款。在修改协议条款后，如用户不同意机智科技对本协议相关条款所做的修改，有权停止使用服务。如果用户继续使用服务，则视为用户接受机智科技对本协议相关条款所做的修改。    4、本协议中限制、免责条款会以加粗形式提示用户注意，请用户务必审慎阅读、充分理解各条款内容，特别是免除或者限制责任的条款，并选择接受或不接受。</p><h5 class='text-center fontBold'>二、账号注册</h5><p>1、用户在使用本服务前需要注册一个“铃之”账号。“铃之”账号应当使用手机号码绑定注册并需要验证，请用户使用本人尚未与“铃之”账号绑定的手机号码，以及未被“铃之”根据本协议封禁的手机号码注册“铃之”账号。“铃之”可以根据用户需求或产品需要对账号注册和绑定的方式进行变更，而无须事先通知用户。&nbsp;    2、用户理解，为了让用户可以正常使用本服务，机智科技需要按照相关法律法规要求进行实名制管理和信息安全管控。<span class='fontBold'>用户清楚，机智科技收集、存储、使用、共享用户的信息，是出于遵守国家法律法规的规定、向用户提供服务、提升服务质量的需要。对机智科技或“铃之”在合理限度内收集、存储、使用、共享用户的账户信息、身份信息、在部分应用场景下可能需要收集地理位置、读取通讯录、读写日历、使用摄像头、启用录音等与服务有关的功能，用户也予以接受和同意。收集数据仅为产品或服务之目的合理使用，不会上传用户隐私数据到服务器。</span>    3、用户同意按照“后台实名、前台自愿”的原则，进行基于本人手机号码等真实身份信息认证后注册账号。用户前台账号名称、头像和简介等注册信息中不得出现违法和不良信息，对含有违法和不良信息的，机智科技有权不予注册；对经公众举报的账号名称、头像和简介等注册信息中查实的违法和不良信息，机智科技也会及时处理，包括但不限于警告、账号封禁 、设备封禁 、功能封禁的处罚，且通知用户处理结果。    4、<span class='fontBold'>用户在注册和使用用户账号名称时，不得有下列情形：    （一）违反宪法或法律法规规定的；    （二）危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；    （三）损害国家荣誉和利益的，损害公共利益的；    （四）煽动民族仇恨、民族歧视，破坏民族团结的；    （五）破坏国家宗教政策，宣扬邪教和封建迷信的；    （六）散布谣言，扰乱社会秩序，破坏社会稳定的；    （七）散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；    （八）侮辱或者诽谤他人，侵害他人合法权益的；    （九）含有法律、行政法规禁止的其他内容的。用户了解并同意，用户以虚假信息骗取账号名称注册，或其账号头像、简介等注册信息存在违法和不良信息或侵犯他人合法权益的，机智科技有权采取通知限期改正、暂停使用、注销登记等措施，并向互联网信息内容主管部门报告。</span>    5、用户理解并同意，为保证账户安全和使用合规，机智科技有权要求用户在实名认证的基础上，要求用户提供更多的身份资料和信息，做进一步的身份认证或资格验证。用户的账户只有在通过这些认证和验证之后，方可获得更多使用本服务的权限。用户的机智科技账户是用户在机智科技进行一切活动的唯一身份识别依据，每一个账户都可以在机智科技独立开展活动，其权利义务全部由用户概况承受。    6、用户须自行保障账户和密码的安全，在任何时候都应在安全的使用环境下按正确的步骤登录、使用然后离开。且须对账户下的全部行为（包括但不限于购买服务、发布信息等）承担责任。<span class='fontBold'>机智科技有合理理由判断用户的账户行为异常时，有权暂时或永久限制账户下所使用的所有产品及/或服务的部分或全部功能。</span> 用户发现有人未经授权使用用户的账户，可以向机智科技申述。    7、用户理解并同意，机智科技有权按照国家机关（包括但不限于公安机关、检察机关、法院等）的要求对用户的注册信息及在机智科技的资金、交易及账户等进行查询、冻结或扣划。</p><h5 class='text-center fontBold'>三、用户的权利和义务</h5><p>1、用户有权根据本协议及“铃之”推送、发布的相关活动规则，享受“铃之”提供的服务。    2、本服务涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，将予以严格保密，除非得到用户的授权或法律另有规定，“铃之”不会向外界披露用户隐私信息。    3、用户注册成功后，将产生用户名和密码等账户信息，用户可以改变用户的密码。用户应谨慎合理的保存、使用其用户名和密码。用户若发现任何非法使用用户账号或存在安全漏洞的情况，请立即通知机智科技并向公安机关报案。    4、用户同意，“铃之”拥有通过邮件、短信、电话、系统公告等形式，向其发送告知信息的权利。    5、<span class='fontBold'>用户不得将在“铃之”注册获得的账户借给他人使用，否则用户应承担由此产生的全部责任，并与实际使用人承担连带责任。</span>    6、用户可以管理其在“铃之”注册获得的账户，并可通过该账户管理成员通信录，邀请好友加入，通过“铃之”服务实现内部成员之间互相收发短信、语音短信以及“铃之”通知的功能，达到内部成员沟通、工作互动等目的。    7、<span class='fontBold'>“铃之”部分功能可能需要付费使用，用户可以自愿选择是否有偿付费使用更多的功能。不付费不影响基本功能的使用。</span>具体费用标准以功能页面规则说明为准。本服务的任何免费试用或免费功能和服务不应视为本服务放弃后续收费的权利。本服务有权依据本协议约定的方式通知用户新的使用正常，若用户继续使用则须按公布的收费标准支付费用。</p><h5 class='text-center fontBold'>四、用户的信息安全承诺</h5><p>用户理解本协议依据国家相关法律法规规章制定，用户获取本服务同意严格遵守以下信息安全承诺：    1、遵守国家有关法律、行政法规和管理规章，严格执行信息安全管理规定。使用本服务的业务或应用应确保符合国家及地方有关法律及法规和管理规章的相关规定，并具有合法的相关业务运营资质证照和许可（如国家主管部门需要），不得从事违法违规和侵害第三方合法权益的活动,否则其责任均由用户承担。若因用户的行为违反相关法律法规和管理规章规定给机智科技造成损失的，机智科技有权要求用户进行损害赔偿。包括但不限于对用户或其他第三方的赔偿或补偿、违约金、主管部门的罚款、诉讼费、律师费、公证费、差旅费等全部费用。    2、不利用通信网络（包括但不限于语音、GPRS、CMNET、短信网关、彩信网关、短彩信资讯平台等）从事危害国家安全、泄露国家机密等违法犯罪活动。    3、不利用通信网络（包括但不限于语音、GPRS、CMNET、短信网关、彩信网关、短彩信资讯平台等）制作、查阅、复制和传播违反宪法和法律、妨碍社会治安破坏国家统一、破坏民族团结、色情、暴力等的信息。    4、保证发送信息的真实性、准确性、合法性负责；发布的内容必须严格遵守《中华人民共和国电信条例》、信息产业部规定的“九不准信息标准”或公安部（公通字【2005】77号）文件规定严格禁止的五大类信息，同时还应遵守《互联网信息服务管理办法》、《全国人民代表大会常务委员会关于加强网络信息保护的决定》及《通信短信息服务管理规定》等国家相关法律法规，不发布和传播有害信息，不以手机作为媒体散发传播违法、不健康、反动等信息，不发布任何含有下列内容之一的信息：    1）反对宪法所确定的基本原则的；危害国家安全，泄漏国家机密，颠覆国家政权，破坏国家统一的；损害国家荣誉和利益的；煽动民族仇恨、民族歧视，破坏民族团结的；破坏国家宗教政策，宣扬邪教和封建迷信的；散布谣言，扰乱社会秩序，破坏社会稳定的；散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；侮辱或者诽谤他人，侵害他人合法权益的；    2）“九不准”：即信息产业部《关于依法打击网络淫秽色情专项行动工作方案的通知》（信部电【2007】231号）定义的九不准信息标准：①政治性新闻信息；②危害国家安全、社会稳定的信息；③泄漏国家机密的信息；④与国家现行政策、法律和法规相抵触的信息；⑤涉及色情淫秽的信息；⑥涉及封建迷信的信息；⑦开办赌博的信息；⑧内容虚假或已失效的信息；⑨有损社会公德和侵犯他人合法权益的信息。    3）“五大类”：即公安部（公通字【2005】77号）文件规定严格禁止的五大类信息：①假冒银行或银联名义进行诈骗或者敲诈勒索公私财物的信息；②散布淫秽、色情、赌博、暴力、凶杀、恐怖内容或者教唆犯罪、传授犯罪方法的信息；③非法销售枪支、弹药、爆炸物、走私车、毒品、迷魂药、淫秽物品、假钞假发票或者明知是犯罪所得赃物的信息；④发布假中奖、假婚介、假招聘，或者引诱、介绍他人卖淫嫖娼的信息；⑤多次发送干扰他人正常生活的，以及含有其他违反宪法、法律、行政法规禁止性规定内容的信息。    4）含有法律、行政法规禁止的其他内容的。    5、短信息业务产品的用途限于企业进行内部员工管理，或者向符合规范要求的客户发布与其业务相关的信息。不得将本服务用作经营性质业务等其他非本协议约定的用途，不得以转售、转租、借用、代发、嵌入等方式提供给第三方使用；不得将服务用于个人业务产品的宣传、推广。    6、用户承诺不会未经对方同意而恶意或欺骗性的添加好友信息，利用“铃之”的服务进行任何超出正常的好友或用户之间内部或外部信息沟通、交流等目的的行为，包括但不限于1.发送垃圾信息、骚扰信息、未经对方同意的广告信息等行为；2.通过自己添加或诱导他人添加等任何方式使自己与其他用户形成好友关系，通过本服务向好友或其他用户发送大量信息的行为。<span class='fontBold'>若用户未遵守以上规定的，机智科技有权做出独立判断并视情采取警示、限制功能、暂停更新、关闭账号等处置措施，保存记录并向有关主管部门报告。用户须对自己在网上的言论和行为承担法律责任。</span></p><h5 class='text-center fontBold'>五、机智科技权利和义务</h5><p>1、机智科技有权根据本服务条款的约定，根据用户的有偿付费使用情况，收取相关服务费用。机智科技根据用户选择的服务以及交纳款项的情况向用户提供合格的网络技术和信息服务。    2、机智科技有义务在现有技术水平的基础上努力确保“铃之”正常运行，尽力避免服务中断或将中断时间限制在最短时间内，保证用户活动的顺利进行。    3、机智科技有权对用户的注册资料进行审查，对存在任何问题或怀疑的注册资料，机智科技有权发出通知询问用户并要求用户做出解释、改正。    4、因网络通信活动的特殊性，机智科技不承担对所有用户的信息发布行为以及与信息发布有关的其他事项进行事先审查的义务，但如发生以下情形，机智科技有权无需征得用户的同意限制用户的活动、向用户核实有关资料、发出警告通知、暂时中止、无限期中止及拒绝向该用户提供服务：    　　A、用户违反本协议或因被提及而纳入本协议的相关规则。    　　B、存在其他用户或第三方通知机智科技，认为某个用户行为存在违法或不当行为，并提供相关证据，而机智科技无法联系到该用户核证或验证该用户向机智科技提供的任何资料或以普通非专业人员的知识水平标准对相关内容进行判别，可以明显认为这些内容或行为可能对他方或机智科技造成财务损失或承担法律责任。    5、根据国家法律、法规、行政规章规定、本协议的内容和机智科技所掌握的事实依据，可以认定该用户存在违法或违反本协议行为以及在机智科技上的其他不当行为，机智科技有权无需征得用户的同意随时做出停止该用户所有活动和相关信息、终止服务提供和封号等处理。    6、机智科技有权在不通知用户的前提下，删除或采取其他限制性措施处理下列信息：包括但不限于以规避费用为目的；存在欺诈等恶意或虚假内容；存在其他试图扰乱正常活动秩序因素；违反公共利益或可能严重损害机智科技和其他用户合法利益。</p><h5 class='text-center fontBold'>六、服务的中断和终止</h5><p>1、“铃之”可依据本协议(包括但不限于机智科技认为用户已违反本协议及相关规则、用户违法违规等)终止对用户的服务，并有权保存用户在“铃之”的全部资料（包括但不限于用户信息和活动信息等）。同时机智科技也有权依据本协议向用户通知后，随时停止提供全部或部分服务。服务终止后，机智科技没有义务转发任何未曾阅读或发送的信息给用户或第三方。    2、用户可自愿申请终止“铃之”服务，但机智科技仍保留下列权利：    　　A、“铃之”有权在法律、法规、行政规章规定的时间内保留该用户的资料，包括但不限于以前的用户资料、活动记录等；    　　B、若终止服务之前，该用户在“铃之”上存在违法行为或违反本协议的行为，机智科技仍可行使本协议所规定的权利。    3、<span class='fontBold'>用户存在下列情况，“铃之”可以终止向该用户提供服务：　　A、在用户违反本协议及相关规则规定时，“铃之”有权终止向该用户提供服务；　　B、机智科技发现用户注册资料中主要内容是虚假的，“铃之”有权随时终止为该用户提供服务；　　C、本协议终止或更新时，用户未确认新的协议的；D、其它机智科技认为需终止服务的情况。</span></p><h5 class='text-center fontBold'>七、机智科技的责任范围</h5><p>当用户接受该协议时，用户应当明确了解并同意：    1、机智科技不能随时预见到任何技术上的问题或其他困难。该等困难可能会导致数据损失或其他服务中断。用户对此予以理解和接受。用户有权利因服务中断事宜向机智科技申述。    2、基于以下原因而造成的利润、商誉、使用、资料损失或其它无形损失，机智科技不承担任何直接、间接、附带、特别、衍生性或惩罚性赔偿（即使机智科技已被告知前款赔偿的可能性）：    　　A、无法使用；    　　B、用户的传输或资料遭到未获授权的存取或变更；    　　C、机智科技中任何第三方之声明或行为；    　　D、其它相关事宜。    3、用户须明白，本服务仅依其当前所呈现的状况提供，本服务涉及到互联网及相关通信等服务，可能会受到各个环节不稳定因素的影响。因此服务存在因上述不可抗力、计算机病毒或黑客攻击、系统不稳定、用户所在位置、用户关机、通信网络、互联网络原因等造成的服务中断或不能满足用户要求的风险。<span class='fontBold'>开通服务的用户须承担以上风险，机智科技对因此导致用户不能发送和接受阅读消息、或传递错误，个人设定之时效、未予储存或其他问题不承担任何责任。对于用户所发布的活动的合法性、真实性及其品质，以及用户履行的能力等，机智科技一律不负任何担保责任。</span>    4、机智科技提供与其它互联网上的网站或资源的链接，用户可能会因此连结至其它运营商经营的网站，但不表示机智科技与这些运营商有任何关系。其它运营商经营的网站均由各经营者自行负责，不属于机智科技控制及负责范围之内。对于存在或来源于此类网站或资源的任何内容、广告、物品或其它资料，机智科技亦不予保证或负责。因使用或依赖任何此类网站或资源发布的或经由此类网站或资源获得的任何内容、物品或服所产生的任何损害或损失，机智科技不负任何直接或间接的责任。    5、<span class='fontBold'>对于用户利用本服务所发布的信息，机智科技有权依据国家相关法律法规对其通讯的信息进行关键词过滤的权利，如发现用户发送内容明确存在违反国家相关法律法规的，机智科技有权作出包括但不限于劝阻、拦截、直至向有关部门举报等行为。</span>机智科技也有权对用户提供的应用产品及内容进行审核，包括但不限于内容审查、功能性测试、安全性测试等。如果发现用户的应用产品不符合国家法律法规、政策规定，或用户提供的应用产品可能侵犯他人合法权益或含有对其他第三方的广告信息等内容，或其他认为不符合要求的情况，机智科技有权不向其提供服务；已提供服务的，机智科技有权立即停止继续向其提供服务，并保存有关记录向相关主管部门报告。但是，该项约定不视为机智科技对用户提供的应用产品提供合法性担保，用户应自行对应用产品提供保证，并承担由此引发的所有责任。</p><h5 class='text-center fontBold'>八、所有权及知识产权条款</h5><p>1、除第三方产品或服务外，“铃之”上所有内容，包括但不限于著作、图片、档案、资讯、资料、架构、页面设计、源代码，其知识产权，包括但不限于商标权、专利权、著作权、商业秘密等，均属于机智科技所有。非经机智科技书面同意，任何人不得擅自使用、修改、反向工程、复制、公开传播、改变、散布、发行或公开发表机智科技上程序或内容。    2、“铃之”所刊登的资料信息（诸如文字、图表、标识、按钮图标、图像、声音文件片段、数字下载、数据编辑和软件），均是机智科技或其内容提供者的财产，受中国和国际版权法的保护。“铃之”上所有内容的汇编是机智科技的排他财产，受中国和国际版权法的保护。“铃之”上所有软件都是机智科技或其关联公司或其软件供应商的财产，受中国和国际版权法的保护。    3、<span class='fontBold'>除法律另有强制性规定外，未经机智科技明确的特别书面许可,任何单位或个人不得以任何方式非法地全部或部分复制、转载、引用、链接、抓取或以其他方式使用“铃之”的信息内容，否则，机智科技有权追究其法律责任。</span></p><h5 class='text-center fontBold'>九、责任限制及不承诺担保</h5><p>1、除非另有明确的书面说明,机智科技及其所包含的或以其它方式通过“铃之”提供给用户的全部信息、内容、材料、产品（包括软件）和服务，均是在'按现状'和'按现有'的基础上提供的。    2、除非另有明确的书面说明,不对机智科技的运营及其包含在“铃之”上的信息、内容、材料、产品（包括软件）或服务作任何形式的、明示或默示的声明或担保（根据中华人民共和国法律另有规定的以外）。    3、不担保“铃之”所包含的或以其它方式通过“铃之”提供给用户或信息接收方的全部信息、内容、材料、产品（包括软件）和服务、其服务器或从“铃之”发出的电子信件、信息没有虚假、病毒或其他有害成分。    4、如因不可抗力或其它机智科技无法控制的原因使系统崩溃或无法正常使用导致丢失有关的信息、记录等，机智科技会合理地尽力协助处理善后事宜。</p><h5 class='text-center fontBold'>十、协议完整性及用户关注义务</h5><p><span class='fontBold'>机智科技要求用户在使用本服务之前阅读本协议及“铃之”的公告。</span>如果本协议中任何一条被视为废止、无效或因任何理由不可执行，该条应视为可分的且并不影响任何其余条款的有效性和可执行性。</p><h5 class='text-center fontBold'>十一、法律管辖和适用</h5><p><span class='fontBold'>本协议的订立、执行和解释及争议的解决均应适用在中华人民共和国大陆地区适用之有效法律（但不包括其冲突法规则）。</span>如发生本协议与适用之法律相抵触时，则这些条款将完全按法律规定重新解释，而其它有效条款继续有效。 如缔约方就本协议内容或其执行发生任何争议，双方应尽力友好协商解决；协商不成时，任何一方均应向广东省深圳市南山区法院提起诉讼。</p><h5 class='text-center fontBold'>十二、申述及通知</h5><p>1、在用户使用“铃之”和发生交易关系的过程中，用户有按照相应的程序进行申诉的权利。用户通过申诉程序，向机智科技申述时，应按照机智科技的要求，如实提供身份证明及相关资料或信息，以便机智科技进行核实。用户应充分理解用户的申诉并不必然被允许，机智科技有权依照自行判断来决定是否同意用户的申诉请求。    2、用户理解并同意，机智科技可依据自行判断，通过网页公告、系统公告、站内信、电子邮件、手机短信或常规的信件传送等方式向用户发出通知，且机智科技可以信赖用户所提供的联系信息是完整、准确且当前有效的；上述通知于发送之日视为已送达收件人。除非本服务条款另有约定或机智科技与用户另行签订的协议明确规定了通知方式，用户发送给机智科技方的通知，应当通过机智科技对外正式公布的通信地址、传真号码、电子邮件地址等联系信息进行送达。</p><h5 class='text-center fontBold'>十三、其他</h5><p>1、“铃之”所有者是指在政府部门依法许可或备案的机智科技经营主体深圳市机智网络科技有限公司。    2、机智科技尊重用户和消费者的合法权利，本协议及“铃之”上发布的各类规则、声明等其他内容，均是为了更好的、更加便利的为用户提供服务。机智科技欢迎用户和社会各界提出意见和建议，机智科技将虚心接受并适时修改本协议及“铃之”上的各类规则。    3、用户点击本协议下方的'同意'按钮即视为用户完全接受本协议，在点击之前请用户再次确认已知悉并完全理解本协议的全部内容。    4、机智科技对本服务协议包括基于本服务协议制定的各项规则在法律允许的最大限度内拥有最终解释权。</p><br><br><h3 class='fontBold' id='privacy' style='margin-bottom:10px'>铃之隐私政策</h3><p class='fontBold'>本政策仅适用于深圳市机智网络科技有限公司的铃之产品及产品服务。最近更新日期：2020年8月。如果您有任何疑问、意见或建议，请通过以下联系方式与我们联系： 电子邮件：jinzhe.deng@jizhitech.com.cn 电话：400-008-0620    本政策将帮助您了解以下内容：    1、我们如何收集和使用您的个人信息    2、我们如何使用 Cookie  和同类技术    3、我们如何共享、转让、公开披露您的个人信息    4、我们如何保护您的个人信息    5、您的权利    6、我们如何处理儿童的个人信息    7、您的个人信息如何在全球范围转移    8、本政策如何更新    9、如何联系我们    深圳市机智网络科技有限公司深知个人信息对您的重要性，并会尽全力保护您的个人信息安全可靠。我们致力于维持您对我们的信任，恪守以下原则，保护您的个人信息：权责一致原则、目的明确原则、选择同意原则、最少够用原则、确保安全原则、主体参与原则、公开透明原则等。同时，深圳市机智网络科技有限公司承诺，我们将按业界成熟的安全标准，采取相应的安全保护措施来保护您的个人信息。请在使用我们的产品（或服务）前，仔细阅读并了解本《铃之隐私政策》。</p><h5 class='text-center fontBold'>一、我们如何收集和使用您的个人信息</h5><p>个人信息是指以电子或者其他方式记录的能够单独或者与其他信息结合识别特定自然人身份或者反映特定自然人活动情况的各种信息。    深圳市机智网络科技有限公司仅会出于本政策所述的以下目的，收集和使用    您的个人信息：</p><p class='fontBold'>（一）为您提供通知管理服务</p><p>1、业务功能一：注册成为用户。</p><p>为完成创建账号，您需提供以下信息：手机号、密码。</p><p>在注册过程中，如果您提供以下额外信息，将有助于我们给您提供更好的服务和体验,您也能使用本服务的更多功能：昵称，头像，性别，生日，身份证，真实姓名认证都是非必填信息。但如果您不提供这些信息，将不会影响使用本服务的基本功能。</p><p>您提供的上述信息，将在您使用本服务期间持续授权我们使用。在您注销账号时，我们将停止使用并删除上述信息。</p><p>上述信息将存储于中华人民共和国境内。如需跨境传输，我们将会单独征得您的授权同意。</p><p>2、业务功能二：发送活动/会议/日常/文件/事务通知。</p><p>（1）在发送活动/会议/文件/日常通知时，需要选择通讯录成员，<span class='fontBold'>需要读取通讯录权限</span>，但不会上传通讯录数据，只存在用户本地。</p><p>（2）会议/活动地址可手工输入，也从地图中选择地点，发出后可以支持地址定位，默认定位为当前位置，<span class='fontBold'>需要获取用户位置权限</span>，本地保存位置信息，不会上传服务器。</p><p>（3）为了减少用户手工输入成本，可以支持语音录入和OCR扫描录入通知内容，因此<span class='fontBold'>需要获取用户语音和摄像头</span>，相册权限，不会存储数据，只是访问数据。</p><p>机智科技收集、存储、使用、共享用户的信息，是出于遵守国家法律法规的规定、向用户提供服务、提升服务质量的需要。对机智科技或“铃之”在合理限度内收集、存储、使用、共享用户的账户信息、身份信息、在<span class='fontBold'>部分应用场景下可能需要收集地理位置、读取通讯录、读写日历、使用摄像头、启用录音等与服务有关的功能，用户予以接受和同意后方可使用对应的服务。</span></p><p>3、业务功能四：充值短信和直播时长。</p><p>我们提供产品内部充值通知条数和直播时长，所以需要接入第三方微信支付和支付宝支付，<span class='fontBold'>需要用户授权跳转到微信支付和支付宝支付</span>，我们按照协议传输相关支付信息，但不会存储第三方的个人信息。</p><p>4、业务功能五：通知提醒</p><p>发送通知可以设置提前提醒，可使用电话提醒和短信提醒，另外针对联系人进行通讯，可以通过本机号码发送短信和拨打电话，<span class='fontBold'>因此需要调用系统拨打电话和短信接口权限</span>，不会收集用户的个人信息</p><p class='fontBold'>（二）开展内部审计、数据分析和研究，改善我们的产品或服务</p><p>为持续不断的优化产品功能和提升用户体验，我们可能会统计用户的点击操作事件信息，用来分析路径操作转化率，分析用户是否对功能感兴趣。但我们不会收集用户的个人隐私信息，只收集用户的操作事件统计埋点。</p><p>当我们要将信息用于本政策未载明的其它用途时，会事先征求您的同意。当我们要将依据本政策基于特定目的收集而来的信息用于其他目的时，会事先征求您的同意。</p><h5 class='text-center fontBold'>二、我们如何使用 Cookie 和同类技术</h5><p class='fontBold'>（一）Cookie</p><p>为确保网站正常运转，我们会在您的计算机或移动设备上存储名为Cookie 的小数据文件。Cookie 通常包含标识符、站点名称以及一些号码和字符。借助于 Cookie，网站能够存储您的通知详情h5等数据。</p><p>我们不会将 Cookie 用于本政策所述目的之外的任何用途。您可根据自己的偏好管理或删除 Cookie。有关详情，请参见 AboutCookies.org。您可以清除计算机上保存的所有 Cookie，大部分网络浏览器都设有阻止Cookie 的功能。但如果您这么做，则需要在每一次访问我们的网站时亲自更改用户设置。如需详细了解如何更改浏览器设置，请访问以下链接：Internet Explorer、Google Chrome、Mozilla Firefox、Safari 和Opera。</p><h5 class='text-center fontBold'>三、我们如何共享、转让、公开披露您的个人信息</h5><p class='fontBold'>（一）共享</p><p>我们不会与深圳市机智网络科技有限公司以外的任何公司、组织和个人分享您的个人信息， 但以下情况除外：</p><p>1、在获取明确同意的情况下共享：获得您的明确同意后，我们会与其他方共享您的个人信息。</p><p>2、我们可能会根据法律法规规定，或按政府主管部门的强制性要求， 对外共享您的个人信息。</p><p>3、与我们的附属公司共享：基于优化和完善产品服务的目的，您的个人信息可能会与深圳市机智网络科技有限公司的附属公司共享。我们只会共享必要的个人信息，且受本隐私政策中所声明目的的约束。附属公司如要改变个人信息的处理目的，将再次征求您的授权同意。</p><p>4、与授权合作伙伴共享：仅为实现本政策中声明的目的，我们的某些服务将由授权合作伙伴提供。我们可能会与合作伙伴共享您的某些个人信息，以提供更好的客户服务和用户体验。我们以后也会对接第三方应用发送通知，包括发邮件，发企业微信，发钉钉。我们仅会出于合法、正当、必要、特定、明确的目的共享您的个人信息，并且只会共享提供服务所必要的个人信息。我们的合作伙伴无权将共享的个人信息用于任何其他用途。</p><p>对我们与之共享个人信息的公司、组织和个人，我们会与其签署严格的保密协定，要求他们按照我们的说明、本隐私政策以及其他任何相关的保密和安全措施来处理个人信息。</p><p class='fontBold'>（二）转让</p><p>我们不会将您的个人信息转让给任何公司、组织和个人，但以下情况除外：</p><p>1、在获取明确同意的情况下转让：获得您的明确同意后，我们会向其他方转让您的个人信息；</p><p>2、在涉及合并、收购或破产清算时，如涉及到个人信息转让，我们会在要求新的持有您个人信息的公司、组织继续受此隐私政策的约束，否则我们将要求该公司、组织重新向您征求授权同意。</p><p class='fontBold'>（三）公开披露</p><p>我们仅会在以下情况下，公开披露您的个人信息：</p><p>1、获得您明确同意后；</p><p>2、基于法律的披露：在法律、法律程序、诉讼或政府主管部门强制性要求的情况下，我们可能会公开披露您的个人信息。</p><h5 class='text-center fontBold'>四、我们如何保护您的个人信息</h5><p>（一）我们已使用符合业界标准的安全防护措施保护您提供的个人信息， 防止数据遭到未经授权访问、公开披露、使用、修改、损坏或丢失。我们会采取一切合理可行的措施，保护您的个人信息。在客户端与服务器之间请求接口报文（如发送通知）时受加密保护；我们会使用加密技术确保数据的保密性；我们会使用受信赖的保护机制防止数据遭到恶意攻击；我们会部署访问控制机制，确保只有授权人员才可访问个人信息；以及我们会举办安全和隐私保护培训课程，加强员工对于保护个人信息重要性的认识。</p><p>（二）我们已经取得了以下认证：国家高新技术企业认证，ISO9001认证，ISO27001认证，CMMI认证企业。</p><p>（三）我们的数据安全能力：关键字拦截，接口请求报文加密，用户密码加密存储，使用RES，md5的加密技术。</p><p>（四）我们会采取一切合理可行的措施，确保未收集无关的个人信息。我们只会在达成本政策所述目的所需的期限内保留您的个人信息，除非需要延长保留期或受到法律的允许。</p><p>（五）互联网并非绝对安全的环境，而且电子邮件、即时通讯、及与其他产品用户的交流方式可能并未加密，我们强烈建议您不要通过此类方式发送个人信息。请使用复杂密码，协助我们保证您的账号安全。</p><p>（六）我们将定期更新并公开安全风险、个人信息安全影响评估等报告的有关内容。您可通过铃之官网获得：http://www.5itz.cn/。</p><p>（七）互联网环境并非百分之百安全，我们将尽力确保或担保您发送给我们的任何信息的安全性。如果我们的物理、技术、或管理防护设施遭到破坏，导致信息被非授权访问、公开披露、篡改、或毁坏，导致您的合法权益受损，我们将承担相应的法律责任。</p><p>（八）在不幸发生个人信息安全事件后，我们将按照法律法规的要求，及时向您告知：安全事件的基本情况和可能的影响、我们已采取或将要采取的处置措施、您可自主防范和降低风险的建议、对您的补救措施等。我们将及时将事件相关情况以邮件、信函、电话、推送通知等方式告知您，难以逐一告知个人信息主体时，我们会采取合理、有效的方式发布公告。</p><p>同时，我们还将按照监管部门要求，主动上报个人信息安全事件的处置情况。</p><h5 class='text-center fontBold'>五、您的权利</h5><p>按照中国相关的法律、法规、标准，以及其他国家、地区的通行做法， 我们保障您对自己的个人信息行使以下权利：</p><p class='fontBold'>（一）访问您的个人信息</p><p>您有权访问您的个人信息，法律法规规定的例外情况除外。如果您想行使数据访问权，可以通过以下方式自行访问：</p><p>账户信息——如果您希望访问或编辑您的账户中的个人资料信息和支付信息、更改您的密码、添加安全信息或关闭您的账户等，您可以进入APP-我的页面执行此类操作。</p><p>如果您无法通过上述路径访问这些个人信息，您发送电子邮件至jinzhe.deng@jizhitech.com.cn。我们将在30天内回复您的访问请求。</p><p>对于您在使用我们的产品或服务过程中产生的其他个人信息，只要我们不需要过多投入，我们会向您提供。如果您想行使数据访问权，请发送电子邮件至jinzhe.deng@jizhitech.com.cn，提供账号和身份认证信息。我们将在30天内回复您的访问请求。</p><p class='fontBold'>（二）更正您的个人信息</p><p>当您发现我们处理的关于您的个人信息有错误时，您有权要求我们做出更正。您可以通过“（一）访问您的个人信息”中罗列的方式提出更正申请。</p><p>如果您无法通过上述路径更正这些个人信息，您可以随时发送电子邮件至jinzhe.deng@jizhitech.com.cn，提供账号和身份认证信息。我们将在30天内回复您的更正请求</p><p class='fontBold'>（三）删除您的个人信息</p><p>在以下情形中，您可以向我们提出删除个人信息的请求：</p><p>1、如果我们处理个人信息的行为违反法律法规；</p><p>2、如果我们收集、使用您的个人信息，却未征得您的同意；</p><p>3、如果我们处理个人信息的行为违反了与您的约定；</p><p>4、如果您不再使用我们的产品或服务，或您注销了账号；</p><p>5、如果我们不再为您提供产品或服务。</p><p>若我们决定响应您的删除请求，我们还将同时通知从我们获得您的个人信息的实体，要求其及时删除，除非法律法规另有规定，或这些实体获得您的独立授权。</p><p>当您从我们的服务中删除信息后，我们可能不会立即备份系统中删除相应的信息，但会在备份更新时删除这些信息。</p><p class='fontBold'>（四）改变您授权同意的范围</p><p>每个业务功能需要一些基本的个人信息才能得以完成（见本政策“第一部分”）。对于额外收集的个人信息的收集和使用，您可以随时给予或收回您的授权同意。</p><p>您可以通过系统设置-应用设置-找到铃之-权限管理-关闭对应的服务权限。</p><p>当您收回同意后，我们将不再处理相应的个人信息。但您收回同意的决定，不会影响此前基于您的授权而开展的个人信息处理。</p><p class='fontBold'>（五）个人信息主体注销账户</p><p>您随时可注销此前注册的账户，您可以通过以下方式自行操作：</p><p>发送邮件到jinzhe.deng@jizhitech.com.cn，提供账号和身份认证信息，我们收到邮件后将在30天内进行注销处理并给于回复。</p><p>在注销账户之后，我们将停止为您提供产品或服务，并依据您的要求， 删除您的个人信息，法律法规另有规定的除外。</p><p class='fontBold'>（六）个人信息主体获取个人信息副本</p><p>您有权获取您的个人信息副本，您可以通过以下方式自行操作：</p><p>发送邮件到jinzhe.deng@jizhitech.com.cn，提供账号和身份认证信息，我们收到邮件后将在30天内进行回复处理。我们只能提供已有的个人信息副本，没有的信息无法提供。</p><p>在技术可行的前提下，例如数据接口匹配，我们还可按您的要求，直接将您的个人信息副本传输给您指定的第三方。</p><p class='fontBold'>（七）约束信息系统自动决策</p><p>在某些业务功能中，我们可能仅依据信息系统、算法等在内的非人工自动决策机制做出决定。如果这些决定显著影响您的合法权益，您有权要求我们做出解释，我们也将提供适当的救济方式。</p><h5 class='text-center fontBold'>六、我们如何处理儿童的个人信息</h5><p>我们的产品、网站和服务主要面向成人。如果没有父母或监护人的同意，儿童不得创建自己的用户账户。</p><p>对于经父母同意而收集儿童个人信息的情况，我们只会在受到法律允许、父母或监护人明确同意或者保护儿童所必要的情况下使用或公开披露此信息。</p><p>尽管当地法律和习俗对儿童的定义不同，但我们将不满 14 周岁的任何人均视为儿童。如果我们发现自己在未事先获得可证实的父母同意的情况下收集了儿童的个人信息，则会设法尽快删除相关数据。</p><h5 class='text-center fontBold'>七、您的个人信息如何在全球范围转移</h5><p>原则上，我们在中华人民共和国境内收集和产生的个人信息，将存储在中华人民共和国境内。</p><p>由于我们通过遍布全球的资源和服务器提供产品或服务，这意味着， 在获得您的授权同意后，您的个人信息可能会被转移到您使用产品或服务所在国家/地区的境外管辖区，或者受到来自这些管辖区的访问。此类管辖区可能设有不同的数据保护法，甚至未设立相关法律。在此类情况下，我们会确保您的个人信息得到在中华人民共和国境内足够同等的保护。例如，我们会请求您对跨境转移个人信息的同意，或者在跨境数据转移之前实施数据去标识化等安全举措。</p><h5 class='text-center fontBold'>八、本政策如何更新</h5><p>我们的隐私政策可能变更。</p><p>未经您明确同意，我们不会削减您按照本隐私政策所应享有的权利。我们会在本页面上发布对本政策所做的任何变更。</p><p>对于重大变更，我们还会提供更为显著的通知（包括对于某些服务， 我们会通过电子邮件、短信息发送通知，或者在产品显著位置进行更新提示，说明隐私政策的具体变更内容）。</p><p>本政策所指的重大变更包括但不限于：</p><p>1、我们的服务模式发生重大变化。如处理个人信息的目的、处理的个人信息类型、个人信息的使用方式等；</p><p>2、我们在所有权结构、组织架构等方面发生重大变化。如业务调整、破产并购等引起的所有者变更等；</p><p>3、个人信息共享、转让或公开披露的主要对象发生变化；</p><p>4、您参与个人信息处理方面的权利及其行使方式发生重大变化；</p><p>5、我们负责处理个人信息安全的责任部门、联络方式及投诉渠道发生变化时；</p><p>6、个人信息安全影响评估报告表明存在高风险时。我们还会将本政策的旧版本存档，供您查阅。</p><h5 class='text-center fontBold'>九、如何联系我们</h5><p>如果您对本隐私政策有任何疑问、意见或建议，通过以下方式与我们联系 电话：400-008-0620</p></body></html>");
    }
}