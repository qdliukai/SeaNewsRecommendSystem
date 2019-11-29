package com.test;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.DicAnalysis;

import java.util.List;

/**
 * Created by Liu
 */
public class SplitWordsByAnsj {

    public List<Keyword> spiltword(String word) {
        KeyWordComputer<?> kwc = new KeyWordComputer(5);
        StopRecognition s = new StopRecognition();
        List<Keyword> result=kwc.computeArticleTfidf(word);
        return result;
    }

    public List<Keyword> splitWordWithTitle(String title, String content){
        KeyWordComputer<?> kwc = new KeyWordComputer(5);
        StopRecognition s = new StopRecognition();
        List<Keyword> result=kwc.computeArticleTfidf(title, content);
        return result;

    }
    public static void main(String[] args) {
        String title = "航运大数据时代到来，未来订舱就像买机票？";
        String word =
                "　　大数据的挖掘和航运科技的快速发展，带来了信息服务平台升级与转型，从而将引发航运业服务模式和盈利方式的革命，并最终实现航运业运作体系的跨越式发展。\n" +
                "　　在11月28日举行的2017上海航运交易论坛上，来自航运、港口界的学者和业内人士针对大数据给港航业带来的新变化进行了讨论。\n" +
                "　　“大数据在未来能让长江中的客户运输集装箱就像买机票一样，可以自主选择最优方案，比如说关注价格可以选择成品低的，关注效率可以选快班。”上海国际港务(集团)股份有限公司党委副书记、总裁严俊说。\n" +
                "　　应用大数据一方面可以判断整体市场的走势，另一方面可以根据日常的经营情况分析和把握市场机会。\n" +
                "　　国际海事组织海事大使、交通运输部原副部长徐祖远说：“大数据将提升港航业的服务质量和效率，可以预见，大数据产生的价值将成为港航业总效益的重要组成部分，掌握港航业大数据的企业家将成为海洋强国的火炬手。”\n" +
                "　　事实上，大数据应用已在港航业诸多环节发挥积极作用。比如，上海港正在利用大数据建设长江江河联运综合服务平台和集卡集约平台。马士基也在与相关企业合作以期通过区块链的应用提高效率降低成本。\n" +
                "　　中国航海学会会长、上海海事大学校长黄有方介绍，大数据、区块链等技术在未来将深刻影响航运业的发展，业界应该加强战略和科技适应能力，应对系统内外的技术突破带来的变革。";

        SplitWordsByAnsj ansj= new SplitWordsByAnsj();
        List<Keyword> res, resTitle;
        res = ansj.spiltword(word);
        res.forEach(keyword -> System.out.println(keyword + "---" + keyword.getScore()));

        resTitle = ansj.splitWordWithTitle(title, word);
        resTitle.forEach(keyword -> System.out.println(keyword + "---" + keyword.getScore()));

        System.out.println(DicAnalysis.parse(word));


//        System.out.println(ansj.spiltword(word).toString());//词组
//        System.out.println(ansj.spiltword(word).getScore());//词组的权重

    }
}
