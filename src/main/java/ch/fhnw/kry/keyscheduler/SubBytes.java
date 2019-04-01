package ch.fhnw.kry.keyscheduler;

public class SubBytes {

    private static final Byte[] sbox = {
            new Byte("63"), new Byte("7c"), new Byte("77"), new Byte("7b"),
            new Byte("f2"), new Byte("6b"), new Byte("6f"), new Byte("c5"),
            new Byte("30"), new Byte("01"), new Byte("67"), new Byte("2b"),
            new Byte("fe"), new Byte("d7"), new Byte("ab"), new Byte("76"),

            new Byte("ca"), new Byte("82"), new Byte("c9"), new Byte("7d"),
            new Byte("fa"), new Byte("59"), new Byte("47"), new Byte("f0"),
            new Byte("ad"), new Byte("d4"), new Byte("a2"), new Byte("af"),
            new Byte("9c"), new Byte("a4"), new Byte("72"), new Byte("c0"),

            new Byte("b7"), new Byte("fd"), new Byte("93"), new Byte("26"),
            new Byte("36"), new Byte("3f"), new Byte("f7"), new Byte("cc"),
            new Byte("34"), new Byte("a5"), new Byte("e5"), new Byte("f1"),
            new Byte("71"), new Byte("d8"), new Byte("31"), new Byte("15"),

            new Byte("04"), new Byte("c7"), new Byte("23"), new Byte("c3"),
            new Byte("18"), new Byte("96"), new Byte("05"), new Byte("9a"),
            new Byte("07"), new Byte("12"), new Byte("80"), new Byte("e2"),
            new Byte("eb"), new Byte("27"), new Byte("b2"), new Byte("75"),

            new Byte("09"), new Byte("83"), new Byte("2c"), new Byte("1a"),
            new Byte("1b"), new Byte("6e"), new Byte("5a"), new Byte("a0"),
            new Byte("52"), new Byte("3b"), new Byte("d6"), new Byte("b3"),
            new Byte("29"), new Byte("e3"), new Byte("2f"), new Byte("84"),

            new Byte("53"), new Byte("d1"), new Byte("00"), new Byte("ed"),
            new Byte("20"), new Byte("fc"), new Byte("b1"), new Byte("5b"),
            new Byte("6a"), new Byte("cb"), new Byte("be"), new Byte("39"),
            new Byte("4a"), new Byte("4c"), new Byte("58"), new Byte("cf"),

            new Byte("d0"), new Byte("ef"), new Byte("aa"), new Byte("fb"),
            new Byte("43"), new Byte("4d"), new Byte("33"), new Byte("85"),
            new Byte("45"), new Byte("f9"), new Byte("02"), new Byte("7f"),
            new Byte("50"), new Byte("3c"), new Byte("9f"), new Byte("a8"),

            new Byte("51"), new Byte("a3"), new Byte("40"), new Byte("8f"),
            new Byte("92"), new Byte("9d"), new Byte("38"), new Byte("f5"),
            new Byte("bc"), new Byte("b6"), new Byte("da"), new Byte("21"),
            new Byte("10"), new Byte("ff"), new Byte("f3"), new Byte("d2"),

            new Byte("cd"), new Byte("0c"), new Byte("13"), new Byte("ec"),
            new Byte("5f"), new Byte("97"), new Byte("44"), new Byte("17"),
            new Byte("c4"), new Byte("a7"), new Byte("7e"), new Byte("3d"),
            new Byte("64"), new Byte("5d"), new Byte("19"), new Byte("73"),

            new Byte("60"), new Byte("81"), new Byte("4f"), new Byte("dc"),
            new Byte("22"), new Byte("2a"), new Byte("90"), new Byte("88"),
            new Byte("46"), new Byte("ee"), new Byte("b8"), new Byte("14"),
            new Byte("de"), new Byte("5e"), new Byte("0b"), new Byte("db"),

            new Byte("e0"), new Byte("32"), new Byte("3a"), new Byte("0a"),
            new Byte("49"), new Byte("06"), new Byte("24"), new Byte("5c"),
            new Byte("c2"), new Byte("d3"), new Byte("ac"), new Byte("62"),
            new Byte("91"), new Byte("95"), new Byte("e4"), new Byte("79"),

            new Byte("e7"), new Byte("c8"), new Byte("37"), new Byte("6d"),
            new Byte("8d"), new Byte("d5"), new Byte("4e"), new Byte("a9"),
            new Byte("6c"), new Byte("56"), new Byte("f4"), new Byte("ea"),
            new Byte("65"), new Byte("7a"), new Byte("ae"), new Byte("08"),

            new Byte("ba"), new Byte("78"), new Byte("25"), new Byte("2e"),
            new Byte("1c"), new Byte("a6"), new Byte("b4"), new Byte("c6"),
            new Byte("e8"), new Byte("dd"), new Byte("74"), new Byte("1f"),
            new Byte("4b"), new Byte("bd"), new Byte("8b"), new Byte("8a"),

            new Byte("70"), new Byte("3e"), new Byte("b5"), new Byte("66"),
            new Byte("48"), new Byte("03"), new Byte("f6"), new Byte("0e"),
            new Byte("61"), new Byte("35"), new Byte("57"), new Byte("b9"),
            new Byte("86"), new Byte("c1"), new Byte("1d"), new Byte("9e"),

            new Byte("e1"), new Byte("f8"), new Byte("98"), new Byte("11"),
            new Byte("69"), new Byte("d9"), new Byte("8e"), new Byte("94"),
            new Byte("9b"), new Byte("1e"), new Byte("87"), new Byte("e9"),
            new Byte("ce"), new Byte("55"), new Byte("28"), new Byte("df"),

            new Byte("8c"), new Byte("a1"), new Byte("89"), new Byte("0d"),
            new Byte("bf"), new Byte("e6"), new Byte("42"), new Byte("68"),
            new Byte("41"), new Byte("99"), new Byte("2d"), new Byte("0f"),
            new Byte("b0"), new Byte("54"), new Byte("bb"), new Byte("16")
    };

    private static final Byte[] invSbox = {
            new Byte("52"), new Byte("09"), new Byte("6a"), new Byte("d5"),
            new Byte("30"), new Byte("36"), new Byte("a5"), new Byte("38"),
            new Byte("bf"), new Byte("40"), new Byte("a3"), new Byte("9e"),
            new Byte("81"), new Byte("f3"), new Byte("d7"), new Byte("fb"),

            new Byte("7c"), new Byte("e3"), new Byte("39"), new Byte("82"),
            new Byte("9b"), new Byte("2f"), new Byte("ff"), new Byte("87"),
            new Byte("34"), new Byte("8e"), new Byte("43"), new Byte("44"),
            new Byte("c4"), new Byte("de"), new Byte("e9"), new Byte("cb"),

            new Byte("54"), new Byte("7b"), new Byte("94"), new Byte("32"),
            new Byte("a6"), new Byte("c2"), new Byte("23"), new Byte("3d"),
            new Byte("ee"), new Byte("4c"), new Byte("95"), new Byte("0b"),
            new Byte("42"), new Byte("fa"), new Byte("c3"), new Byte("4e"),

            new Byte("08"), new Byte("2e"), new Byte("a1"), new Byte("66"),
            new Byte("28"), new Byte("d9"), new Byte("24"), new Byte("b2"),
            new Byte("76"), new Byte("5b"), new Byte("a2"), new Byte("49"),
            new Byte("6d"), new Byte("8b"), new Byte("d1"), new Byte("25"),

            new Byte("72"), new Byte("f8"), new Byte("f6"), new Byte("64"),
            new Byte("86"), new Byte("68"), new Byte("98"), new Byte("16"),
            new Byte("d4"), new Byte("a4"), new Byte("5c"), new Byte("cc"),
            new Byte("5d"), new Byte("65"), new Byte("b6"), new Byte("92"),

            new Byte("6c"), new Byte("70"), new Byte("48"), new Byte("50"),
            new Byte("fd"), new Byte("ed"), new Byte("b9"), new Byte("da"),
            new Byte("5e"), new Byte("15"), new Byte("46"), new Byte("57"),
            new Byte("a7"), new Byte("8d"), new Byte("9d"), new Byte("84"),

            new Byte("90"), new Byte("d8"), new Byte("ab"), new Byte("00"),
            new Byte("8c"), new Byte("bc"), new Byte("d3"), new Byte("0a"),
            new Byte("f7"), new Byte("e4"), new Byte("58"), new Byte("05"),
            new Byte("b8"), new Byte("b3"), new Byte("45"), new Byte("06"),

            new Byte("d0"), new Byte("2c"), new Byte("1e"), new Byte("8f"),
            new Byte("ca"), new Byte("3f"), new Byte("0f"), new Byte("02"),
            new Byte("c1"), new Byte("af"), new Byte("bd"), new Byte("03"),
            new Byte("01"), new Byte("13"), new Byte("8a"), new Byte("6b"),

            new Byte("3a"), new Byte("91"), new Byte("11"), new Byte("41"),
            new Byte("4f"), new Byte("67"), new Byte("dc"), new Byte("ea"),
            new Byte("97"), new Byte("f2"), new Byte("cf"), new Byte("ce"),
            new Byte("f0"), new Byte("b4"), new Byte("e6"), new Byte("73"),

            new Byte("96"), new Byte("ac"), new Byte("74"), new Byte("22"),
            new Byte("e7"), new Byte("ad"), new Byte("35"), new Byte("85"),
            new Byte("e2"), new Byte("f9"), new Byte("37"), new Byte("e8"),
            new Byte("1c"), new Byte("75"), new Byte("df"), new Byte("6e"),

            new Byte("47"), new Byte("f1"), new Byte("1a"), new Byte("71"),
            new Byte("1d"), new Byte("29"), new Byte("c5"), new Byte("89"),
            new Byte("6f"), new Byte("b7"), new Byte("62"), new Byte("0e"),
            new Byte("aa"), new Byte("18"), new Byte("be"), new Byte("1b"),

            new Byte("fc"), new Byte("56"), new Byte("3e"), new Byte("4b"),
            new Byte("c6"), new Byte("d2"), new Byte("79"), new Byte("20"),
            new Byte("9a"), new Byte("db"), new Byte("c0"), new Byte("fe"),
            new Byte("78"), new Byte("cd"), new Byte("5a"), new Byte("f4"),

            new Byte("1f"), new Byte("dd"), new Byte("a8"), new Byte("33"),
            new Byte("88"), new Byte("07"), new Byte("c7"), new Byte("31"),
            new Byte("b1"), new Byte("12"), new Byte("10"), new Byte("59"),
            new Byte("27"), new Byte("80"), new Byte("ec"), new Byte("5f"),

            new Byte("60"), new Byte("51"), new Byte("7f"), new Byte("a9"),
            new Byte("19"), new Byte("b5"), new Byte("4a"), new Byte("0d"),
            new Byte("2d"), new Byte("e5"), new Byte("7a"), new Byte("9f"),
            new Byte("93"), new Byte("c9"), new Byte("9c"), new Byte("ef"),

            new Byte("a0"), new Byte("e0"), new Byte("3b"), new Byte("4d"),
            new Byte("ae"), new Byte("2a"), new Byte("f5"), new Byte("b0"),
            new Byte("c8"), new Byte("eb"), new Byte("bb"), new Byte("3c"),
            new Byte("83"), new Byte("53"), new Byte("99"), new Byte("61"),

            new Byte("17"), new Byte("2b"), new Byte("04"), new Byte("7e"),
            new Byte("ba"), new Byte("77"), new Byte("d6"), new Byte("26"),
            new Byte("e1"), new Byte("69"), new Byte("14"), new Byte("63"),
            new Byte("55"), new Byte("21"), new Byte("0c"), new Byte("7d")
    };

    public static Byte get(String nr, Base base) {
        return sbox[Integer.parseInt(nr, base.getBase())];
    }

    public static Byte get(String hex) {
        return get(hex, Base.HEX);
    }

    public static Byte get(int dez) {
        return sbox[dez];
    }

    public static Byte get(Byte b) {
        return get(b.getDez());
    }

    public static Byte invGet(String nr, Base base) {
        return invSbox[Integer.parseInt(nr, base.getBase())];
    }

    public static Byte invGet(String hex) {
        return invGet(hex, Base.HEX);
    }

    public static Byte invGet(int dez) {
        return invSbox[dez];
    }

    public static Byte invGet(Byte b) {
        return invGet(b.getDez());
    }

}
