package com.ssafy.api.controller;

import com.ssafy.api.request.LikeListReq;
import com.ssafy.api.request.NovelTagSearchReq;
import com.ssafy.api.request.UserTagReq;
import com.ssafy.api.response.NovelInfoRes;
import com.ssafy.api.service.NovelService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Novel;
import com.ssafy.db.entity.Tag;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 소설 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "소설 API", tags = {"Novel"})
@RestController
@RequestMapping("/api/v1/novel")
public class NovelController {

    @Autowired
    NovelService novelService;

    @Autowired
    UserService userService;

    //소설의 모든 리스트 불러오기


    @GetMapping("/{novelNo}")
    @ApiOperation(value = "소설 정보 조회", notes = "소설의 정보를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당하는 소설 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<NovelInfoRes> getNovelInfo(@PathVariable("novelNo") Long novelNo) {
        NovelInfoRes novelInfoRes = novelService.getNovelInfoByNovelNo(novelNo);
        return ResponseEntity.status(200).body(novelInfoRes);
    }

    @GetMapping("/search/writer/{novelWriter}")
    @ApiOperation(value = "작가로 소설 조회", notes = "작가가 작성한 소설을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 작가의 이름이 틀렸거나, 해당하는 소설 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getNovelsByWriter(@PathVariable("novelWriter") String novelWriter) {
        //안 됐던 이유 -> List를 넣어야 하는데 별안간 List<Novel> 요로코롬 해서...
        // 몰?루
        List<Novel> shelf = novelService.getNovelsByNovelWriter(novelWriter);
        return ResponseEntity.status(200).body(shelf);
    }

    @GetMapping("/search/title/{novelTitle}")
    @ApiOperation(value = "제목으로 소설 조회", notes = "제목을 입력하여 소설을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 제목의 소설 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getNovelsByTitle(@PathVariable("novelTitle") String novelTitle) {
        List<Novel> shelf = novelService.getNovelsByNovelTitle(novelTitle);
        return ResponseEntity.status(200).body(shelf);
    }

    @GetMapping("/search/platform/{novelPlatfrom}")
    @ApiOperation(value = "플랫폼 별 소설 조회", notes = "플랫폼 별 소설을 조회한다. (네이버시리즈, 카카오페이지)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 플랫폼 소설 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getNovelsByPlatform(@PathVariable("novelPlatfrom") String novelPlatfrom) {
        List<Novel> shelf = novelService.getNovelsByNovelPlatform(novelPlatfrom);
        return ResponseEntity.status(200).body(shelf);
    }

    @PostMapping("/search/tags")
    @ApiOperation(value = "태그로 소설 조회", notes = "태그를 입력받아 소설을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 태그의 소설 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List<Novel>> getNovelsByTags
            (@RequestBody @ApiParam(value = "태그들") NovelTagSearchReq tagsInfo) {
        List<Novel> shelf = novelService.getNovelsByTag(tagsInfo);
        //태그를 받아 올 거임 근데 한 번 클릭하면 추가되게? 아니면 추가된 채로 검색을 누르면 변하게?
        return ResponseEntity.status(200).body(shelf);
    }

    @GetMapping("/search/bigtag/{tagGenre}")
    @ApiOperation(value = "대분류별 태그 조회", notes = "대분류 별 태그를 조회한다. (0 - 로맨스, 로판 / 1 - 판타지 / 2 - BL)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 태그 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getTagsByGenre(@PathVariable("tagGenre") int tagGenre) {
        List<Tag> tag = novelService.getTagsByTagGenre(tagGenre);
        return ResponseEntity.status(200).body(tag);
    }

    @GetMapping("/search/romancetag/{tagType}")
    @ApiOperation(value = "로맨스 분류별 태그 조회", notes = "로맨스, 로판 내의 분류별 태그를 조회한다. (1 - 장르 / 2 - 소재 / 3 - 남주 / 4 - 여주 / 5 - 관계 / 6 - 분위기, 기타)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 태그 타입 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getRomanceTagsByType(@PathVariable("tagType") int tagType) {
        List<Tag> tag = novelService.getRomanceTagsByTagType(tagType);
        return ResponseEntity.status(200).body(tag);
    }

    @GetMapping("/search/fantasytag/{tagType}")
    @ApiOperation(value = "판타지 분류별 태그 조회", notes = "판타지 내의 분류별 태그를 조회한다. (1 - 장르 / 2 - 스토리 / 3 - 직업, 소재 / 4 - 분위기, 기타)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 태그 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getFantasyTagsByType(@PathVariable("tagType") int tagType) {
        List<Tag> tag = novelService.getFantasyTagsByTagType(tagType);
        return ResponseEntity.status(200).body(tag);
    }

    @GetMapping("/search/bltag/{tagType}")
    @ApiOperation(value = "BL 분류별 태그 조회", notes = "BL 내의 분류별 태그를 조회한다. (1 - 장르 / 2 - 소재 / 3 - 공 / 4 - 수 / 5 - 관계 / 6 - 분위기/기타)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당 태그 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List> getBlTagsByType(@PathVariable("tagType") int tagType) {
        List<Tag> tag = novelService.getBlTagsByTagType(tagType);
        return ResponseEntity.status(200).body(tag);
    }

    @PostMapping("/tags")
    @ApiOperation(value = "특정 태그를 선호 태그 목록에 추가", notes = "선호하는 태그 목록에 특정 태그를 추가한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "실패"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> addTag
            (@RequestBody @ApiParam(value = "회원 정보 및 태그 정보", required = true) UserTagReq userTagInfo) {

        boolean success = userService.addTags(userTagInfo);
        if (success = true)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        else
            return ResponseEntity.status(404).body(BaseResponseBody.of(404, "Fail"));
    }

    @PostMapping("/novels")
    @ApiOperation(value = "특정 소설을 좋아요 목록에 추가", notes = "좋아요 목록에 특정 소설을 추가한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "실패"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> addLikeList
            (@RequestBody @ApiParam(value = "회원 정보 및 태그 정보", required = true) LikeListReq likeListInfo) {

        boolean success = userService.addLikeList(likeListInfo);
        if (success == true)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        else
            return ResponseEntity.status(404).body(BaseResponseBody.of(404, "Fail"));
    }

    @PostMapping("/novels/upload")
    @ApiOperation(value = "소설을 db에 추가", notes = "소설을 db에 추가")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "실패"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> addNovels
            () {
        try {
            novelService.addNovels();
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        } catch(Exception e)
        {
            return ResponseEntity.status(200).body(BaseResponseBody.of(400, "fail"));
        }
    }
}


