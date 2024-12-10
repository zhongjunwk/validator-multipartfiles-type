package com.zhongjun.validator.filevalidator.constant;

import lombok.AllArgsConstructor;

/**
 * 文件类型
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 **/
@SuppressWarnings("all")
@AllArgsConstructor
public enum FileType {
    PS("ps"),
    JAVA("java"),
    DBX("dbx"),
    QDF("qdf"),
    WMV("wmv"),
    PDF("pdf"),
    INI("ini"),
    MF("mf"),
    JAR("jar"),
    RAR("rar"),
    AVI("avi"),
    BMP("bmp"),
    CLASS("class"),
    MOV("mov"),
    JPG("jpg"),
    ZIP("zip"),
    EML("eml"),
    TORRENT("torrent"),
    PSD("psd"),
    EXE("exe"),
    GZ("gz"),
    RAM("ram"),
    PWL("pwl"),
    MPG("mpg"),
    RTF("rtf"),
    CHM("chm"),
    MP4("mp4"),
    PNG("png"),
    MID("mid"),
    MXP("mxp"),
    TIF("tif"),
    BAT("bat"),
    WPD("wpd"),
    PST("pst"),
    FLV("flv"),
    XLS("xls"),
    XLSX("xlsx"),
    DWG("dwg"),
    WAV("wav"),
    GIF("gif"),
    RMVB("rmvb"),
    MP3("mp3"),
    MDB("mdb"),
    JSON("json"),
    TXT("txt"),
    CSV("csv"),
    JSP("jsp");

    private final String name;

    public static String match(String name) {
        for (FileType enums : FileType.values()) {
            if (enums.getName() == name) {
                return enums.getName();
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }
}
