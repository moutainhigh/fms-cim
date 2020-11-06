package org.fms.cim.server.webapp.archives.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.TgInfoDomain;
import org.fms.cim.common.service.ITgInfoService;
import org.fms.cim.common.vo.uas.TgInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.riozenc.titanTool.common.json.utils.GsonUtils;
import com.riozenc.titanTool.spring.web.http.HttpResult;
import com.riozenc.titanTool.spring.web.http.HttpResultPagination;

import reactor.core.publisher.Mono;

/**
 * 台区
 *
 * @author riozenc
 *
 */

@ControllerAdvice
@RequestMapping("tgInfo")
public class TgInfoAction {

	@Autowired
	@Qualifier("tgInfoServiceImpl")
	private ITgInfoService tgInfoService;

	@ResponseBody
	@PostMapping(params = "method=getTgDropdown")
	public Mono<List<TgInfoVO>> getTgDropdown() {
		TgInfoVO tgInfoVO =  new TgInfoVO();
		tgInfoVO.setStatus("1");
		List<TgInfoVO> tgInfoVOs = tgInfoService.findByWhere(tgInfoVO);
		return Mono.just(tgInfoVOs);
	}

	@ResponseBody
	@PostMapping(params = "method=getTgInfo")
	public Mono<HttpResultPagination<?>> getTgInfo(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		TgInfoVO tgInfoVO = GsonUtils.readValue(body, TgInfoVO.class);
		return Mono.just(new HttpResultPagination(tgInfoVO, tgInfoService.findByWhere(tgInfoVO)));
	}

	@ResponseBody
	@RequestMapping(params = "method=updateTgInfo")
	public Mono<HttpResult> updateTgInfo(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		TgInfoVO tgInfoVO = GsonUtils.readValue(body, TgInfoVO.class);
		int count = tgInfoService.update(tgInfoVO);
		if (count > 0) {
			return Mono.just(new HttpResult<>(HttpResult.SUCCESS, "更新用住宅用户信息成功"));
		} else {
			return Mono.just(new HttpResult<>(HttpResult.ERROR, "更新用住宅用户信息失败"));
		}
	}

	@ResponseBody
	@RequestMapping(params = "method=addTgInfo")
	public Mono<HttpResult> addTgInfo(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException {
		TgInfoVO tgInfoVO = GsonUtils.readValue(body, TgInfoVO.class);
		// 台区编号查重
		TgInfoVO t = new TgInfoVO();
		t.setTgNo(tgInfoVO.getTgNo());
		List<TgInfoVO> list = tgInfoService.findByNo(t);
		if (list.size() > 0) {
			return Mono.just(new HttpResult<>(HttpResult.ERROR, "新增台区信息失败，台区编号重复"));
		}

		tgInfoVO.setCreateDate(new Date());
		int count = tgInfoService.insert(tgInfoVO);
		if (count > 0) {
			return Mono.just(new HttpResult<>(HttpResult.SUCCESS, "新增台区信息成功"));
		} else {
			return Mono.just(new HttpResult<>(HttpResult.ERROR, "新增台区信息失败"));
		}
	}
	
	@ResponseBody
    @PostMapping(params = "method=insert")
    public HttpResult<?> insert(@RequestBody TgInfoVO tgInfoVO) {
        int i = tgInfoService.insert(tgInfoVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "新增成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "新增失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=update")
    public HttpResult<?> update(@RequestBody TgInfoVO tgInfoVO) {
        int i = tgInfoService.update(tgInfoVO);

        if (i > 0) {
            return new HttpResult<String>(HttpResult.SUCCESS, "编辑成功", null);
        } else {
            return new HttpResult<String>(HttpResult.ERROR, "编辑失败", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=delete")
    public HttpResult<?> delete(@RequestBody List<TgInfoVO> deleteList) throws Exception {
        HttpResult httpResult = tgInfoService.deleteList(deleteList);
        return httpResult;
    }

    @ResponseBody
    @PostMapping(params = "method=findByKey")
    public HttpResult<?> findByKey(@RequestBody TgInfoVO tgInfoVO) {
        TgInfoVO modelVo = tgInfoService.findByKey(tgInfoVO);

        if (modelVo != null) {
            return new HttpResult<TgInfoVO>(HttpResult.SUCCESS, "获取成功", modelVo);
        } else {
            return new HttpResult<TgInfoVO>(HttpResult.ERROR, "未检索到相关数据!", null);
        }

    }

    @ResponseBody
    @PostMapping(params = "method=findByWhere")
    public HttpResultPagination<?> findByWhere(@RequestBody TgInfoVO tgInfoVO) {

        return new HttpResultPagination(tgInfoVO, tgInfoService.findByWhere(tgInfoVO));
    }
}
