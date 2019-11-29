package com.hanlp;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class HanLPTest01 {

	public static void main(String[] args) {
		func1();
	}
	
	public static void func1() {
		// 常规分词
		List<Term> segment1 = HanLP.segment("拥抱海洋大数据，推进河北海洋科技创新发展，河北海洋经济调查启动，国内外海洋地质数据库网站。");
		System.out.println(segment1);
		// 标准分词
		List<Term> segment2 = StandardTokenizer.segment("拥抱海洋大数据，推进河北海洋科技创新发展，河北海洋经济调查启动，国内外海洋地质数据库网站。");
		System.out.println(segment2);
		// NLP分词
		List<Term> segment3 = NLPTokenizer.segment("拥抱海洋大数据，推进河北海洋科技创新发展，河北海洋经济调查启动，国内外海洋地质数据库网站。");
		System.out.println(segment3);
		// 极速词典分词
		List<Term> segment4 = SpeedTokenizer.segment("拥抱海洋大数据，推进河北海洋科技创新发展，河北海洋经济调查启动，国内外海洋地质数据库网站。");
		System.out.println(segment4);
		
		String[] testCase = new String[]{
		        "北京市海淀区中关村北大街37号天龙大厦3层",
		        "安徽合肥市蜀山区城区隆兴驾校西南400米(十里店路北)清溪家园2栋1002",
		        "山东省青岛市崂山区沙子口街道宁夏路208号",
		        "衢江经济开发区百灵北路8号",
		};
		Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
		for (String sentence : testCase)
		{
		    List<Term> termList = segment.seg(sentence);
		    System.out.println(termList);
		}
	}
}
